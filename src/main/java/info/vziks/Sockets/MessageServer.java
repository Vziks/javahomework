package info.vziks.Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class MessageServer {
    private int port;
    private Connection connection;

    public MessageServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                printMessage(connection.readMessage());
                connection.sendMessage(new Message("server", "сообщение получено"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(Message message) {
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {

        try (InputStream inputStream = MessageServer.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);

            MessageServer messageServer = new MessageServer(Integer.parseInt(properties.getProperty("port")));
            try {
                messageServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
