package info.vziks.homework17.App;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MessageClient extends Config {
    private Scanner scanner;
    private Connection connection;
    private String text;


    public MessageClient() {
        this.scanner = new Scanner(System.in);
    }

    public MessageClient setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    public void start() {
        System.out.println("Enter name");
        String name = scanner.nextLine();

        Thread readThread = new Thread(new Reader());
        readThread.setDaemon(true);
        readThread.start();

        do {
            System.out.println("Enter message text or write \"exit\" to close connection");
            text = scanner.next();
            if (text != null && !text.isEmpty()) {
                Message message = new Message(name, text);
                try {
                    connection.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } while (!"exit".equals(text));
    }

    class Reader implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = null;
                try {
                    message = connection.readMessage();
                } catch (IOException | ClassNotFoundException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("Message from " + Objects.requireNonNull(message).getSender() + ": " + message.getText());
            }
        }
    }
}


