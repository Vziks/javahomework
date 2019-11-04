package info.vziks.homework9;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

public class HomeWork9 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork6
     */
    public static void main(String[] args) throws TaskCommandException {
        getTasks().addCommand(new Task91Command());
        getTasks().addCommand(new Task92Command());
        getTasks().runTasks();
    }
}