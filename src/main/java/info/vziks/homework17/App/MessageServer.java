package info.vziks.homework17.App;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageServer extends Config {
    private Map<SocketAddress, Connection> socketAddressConnectionMap = Collections.synchronizedMap(new HashMap<>());
    private LinkedBlockingDeque<Message> messages = new LinkedBlockingDeque<>();

    public void start() throws IOException {

        new Thread(new Writer()).start();
        try (ServerSocket serverSocket = new ServerSocket(this.getPort())) {
            System.out.println("Server started...");
            Connection connection;
            while (true) {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                System.out.println(socket.getRemoteSocketAddress());
                socketAddressConnectionMap.put(socket.getRemoteSocketAddress(), connection);
                new Thread(new Reader(connection)).start();
            }
        }
    }

    class Reader implements Runnable {
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (connection.getSocket().isClosed()) {
                    socketAddressConnectionMap.remove(connection.getSocket().getRemoteSocketAddress());
                    Thread.currentThread().interrupt();
                }
                try {
                    Message message = connection.readMessage();
                    message.setSocketAddress(connection.getSocket().getRemoteSocketAddress());
                    messages.put(message);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    Thread.currentThread().interrupt();
                    socketAddressConnectionMap.remove(connection.getSocket().getRemoteSocketAddress());
                }
            }
        }
    }

    class Writer implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Message message = messages.take();
                    for (Map.Entry<SocketAddress, Connection> entry : socketAddressConnectionMap.entrySet()) {
                        if (!entry.getKey().equals(message.getSocketAddress()) && !entry.getValue().getSocket().isClosed()) {
                            try {
                                entry.getValue().sendMessage(message);
                            } catch (IOException e) {
                                socketAddressConnectionMap.remove(entry.getKey());
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
