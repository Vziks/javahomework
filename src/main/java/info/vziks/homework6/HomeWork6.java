package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.text.ParseException;

/**
 * Class HomeWork6
 *
 * @author Anton Prokhorov
 */
public class HomeWork6 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork6
     */
    public static void main(String[] args) throws TaskCommandException, ParseException {
        getTasks().addCommand(new Task61Command());
        getTasks().runTasks();
    }
}