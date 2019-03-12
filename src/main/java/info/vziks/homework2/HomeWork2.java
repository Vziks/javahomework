package info.vziks.homework2;


import info.vziks.TaskCommands;

/**
 * Class HomeWork2
 *
 * @author Anton Prokhorov
 */
public class HomeWork2 {

    /**
     * @param args the input arguments
     */
    public static void main(String[] args) {

        TaskCommands tasks = new TaskCommands();

        tasks.addCommand(new Task21Command());
        tasks.addCommand(new Task22Command());
        tasks.addCommand(new Task23Command());
        tasks.addCommand(new Task24Command());
        tasks.addCommand(new Task25Command());
        tasks.addCommand(new Task26Command());
        tasks.addCommand(new Task27Command());
        tasks.addCommand(new Task28Command());
        tasks.addCommand(new Task29Command());
        tasks.runTasks();
    }
}
