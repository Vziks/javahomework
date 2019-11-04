package info.vziks.utils;

import info.vziks.exceptions.TaskCommandException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class TaskCommands
 *
 * @author Anton Prokhorov
 */
public class TaskCommands {

    private List<Command> commandList = new ArrayList<>();

    /**
     * Add command.
     *
     * @param command the command
     */
    public void addCommand(Command command) {
        commandList.add(command);
    }

    /**
     * Run tasks.
     */
    public void runTasks() throws TaskCommandException, ParseException {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
