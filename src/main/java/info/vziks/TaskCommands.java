package info.vziks;

import info.vziks.Command;

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
    public void runTasks() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
