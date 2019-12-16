package info.vziks.homework17;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework17.App.MessageServer;
import info.vziks.utils.Command;

import java.io.IOException;

public class Task171Command implements Command {
    @Override
    public void execute() throws TaskCommandException {
        MessageServer messageServer = new MessageServer();
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
