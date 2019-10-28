package info.vziks.homework1;

import info.vziks.utils.HomeWorkMain;
import info.vziks.exceptions.TaskCommandException;

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
    public static void main(String[] args) throws TaskCommandException {
        getTasks().addCommand(new Task11Command());
        getTasks().addCommand(new Task12Command());
        getTasks().addCommand(new Task13Command());
        getTasks().runTasks();
    }}
