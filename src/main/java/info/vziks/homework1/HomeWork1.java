package info.vziks.homework1;


import info.vziks.homework1.exceptions.Task1CommandExeption;

/**
 * Class HomeWork1
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class HomeWork1 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws Task1CommandExeption {

        TaskCommands tasks = new TaskCommands();

        tasks.addCommand(new Task1Command());
        tasks.addCommand(new Task2Command());
        tasks.addCommand(new Task3Command());
        tasks.addCommand(new Task4Command());
        tasks.addCommand(new Task5Command());
        tasks.addCommand(new Task6Command());

        tasks.runTasks();
    }
}
