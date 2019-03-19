package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

public class HomeWork4  extends HomeWorkMain {
    public static void main(String[] args) throws TaskCommandException {
        getTasks().addCommand(new Task41Command());
//        getTasks().addCommand(new Task42Command());
//        getTasks().addCommand(new Task43Command());
//        getTasks().addCommand(new Task44Command());
        getTasks().runTasks();
    }
}
