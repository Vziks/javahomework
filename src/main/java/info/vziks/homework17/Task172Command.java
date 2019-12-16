package info.vziks.homework17;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework17.App.Connection;
import info.vziks.homework17.App.MessageClient;
import info.vziks.utils.Command;

import java.io.IOException;
import java.net.Socket;

public class Task172Command implements Command {
    @Override
    public void execute() throws TaskCommandException {

        try {
            MessageClient messageClient = new MessageClient();
            Connection connection = new Connection(new Socket(messageClient.getIp(), messageClient.getPort()));
            messageClient.setConnection(connection);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
