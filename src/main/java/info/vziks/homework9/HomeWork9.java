package info.vziks.homework9;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork9 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork6
     */
    public static void main(String[] args) throws ParseException, IOException {
        getTasks().addCommand(new Task91Command());
        getTasks().addCommand(new Task92Command());
        getTasks().addCommand(new Task93Command());
        getTasks().runTasks();
    }
}