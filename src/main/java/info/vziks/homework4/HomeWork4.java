package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

/**
 * Class HomeWork4
 *
 * @author Anton Prokhorov
 */
public class HomeWork4 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork4
     */
    public static void main(String[] args) throws TaskCommandException {
        getTasks().addCommand(new Task41Command());
        getTasks().runTasks();
    }
}
