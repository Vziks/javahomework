package info.vziks.homework13;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework13.EnumException.App;
import info.vziks.homework13.EnumException.Status;
import info.vziks.utils.Command;

import java.io.IOException;

public class Task132Command implements Command {
    @Override
    public void execute() throws TaskCommandException {
        App app = new App();

        for (Status op : Status.values()) {
            try {
                app.getHashMap().get(op).throwException();
            } catch (IOException io) {
                App.printError(io);
            }
        }
    }
}
