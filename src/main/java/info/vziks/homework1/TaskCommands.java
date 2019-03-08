package info.vziks.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TaskCommands
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
class TaskCommands {

    private List<Command> commandList = new ArrayList<>();

    /**
     * Add command.
     *
     * @param command the command
     */
    void addCommand(Command command) {
        commandList.add(command);
    }

    /**
     * Run tasks.
     */
    void runTasks() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
