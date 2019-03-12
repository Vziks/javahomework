package info.vziks.homework1;


import info.vziks.TaskCommands;
import info.vziks.exceptions.TaskCommandException;

/**
 * Class HomeWork1
 *
 * @author Anton Prokhorov
 */
public class HomeWork1 {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument Task1Command
     */
    public static void main(String[] args) throws TaskCommandException {

        TaskCommands tasks = new TaskCommands();

        tasks.addCommand(new Task11Command());
        tasks.addCommand(new Task12Command());
        tasks.addCommand(new Task13Command());
        tasks.addCommand(new Task14Command());
        tasks.addCommand(new Task15Command());
        tasks.addCommand(new Task16Command());

        tasks.runTasks();
    }
}
