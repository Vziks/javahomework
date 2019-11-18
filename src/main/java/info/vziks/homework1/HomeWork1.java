package info.vziks.homework1;

import info.vziks.utils.HomeWorkMain;
import info.vziks.exceptions.TaskCommandException;

import java.io.IOException;
import java.text.ParseException;

/**
 * Class HomeWork1
 *
 * @author Anton Prokhorov
 */
public class HomeWork1 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument Task1Command
     */
    public static void main(String[] args) throws ParseException, IOException {
        getTasks().addCommand(new Task11Command());
        getTasks().addCommand(new Task12Command());
        getTasks().addCommand(new Task13Command());
        getTasks().runTasks();
    }
}
