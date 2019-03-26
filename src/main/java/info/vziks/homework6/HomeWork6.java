package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

public class HomeWork6 extends HomeWorkMain {
    public static void main(String[] args) throws TaskCommandException {
        getTasks().addCommand(new Task61Command());
        getTasks().runTasks();
    }
}
