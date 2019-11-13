package info.vziks.homework11;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork11 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork6
     */
    public static void main(String[] args) throws TaskCommandException, ParseException, IOException {
        getTasks().addCommand(new Task111Command());
        getTasks().addCommand(new Task112Command());
        getTasks().runTasks();
    }
}