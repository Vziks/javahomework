package info.vziks.homework3;

import info.vziks.utils.HomeWorkMain;

/**
 * Class HomeWork3
 *
 * @author Anton Prokhorov
 */
public class HomeWork3 extends HomeWorkMain {
    public static void main(String[] args) {
        getTasks().addCommand(new Task31Command());
        getTasks().addCommand(new Task32Command());
        getTasks().addCommand(new Task33Command());
        getTasks().addCommand(new Task34Command());
        getTasks().addCommand(new Task35Command());
        getTasks().addCommand(new Task36Command());
        getTasks().addCommand(new Task37Command());
        getTasks().runTasks();
    }
}
