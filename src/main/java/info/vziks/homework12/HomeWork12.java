package info.vziks.homework12;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork12 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork6
     */
    public static void main(String[] args) throws TaskCommandException, ParseException, IOException {
        getTasks().addCommand(new Task121Command());
        getTasks().runTasks();
    }
}