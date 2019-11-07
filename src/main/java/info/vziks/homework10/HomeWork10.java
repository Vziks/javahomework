package info.vziks.homework10;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework9.Task92Command;
import info.vziks.homework9.Task93Command;
import info.vziks.utils.HomeWorkMain;

import java.text.ParseException;

public class HomeWork10 extends HomeWorkMain {

    /**
     * @param args the input arguments
     * @throws TaskCommandException Invalid argument HomeWork6
     */
    public static void main(String[] args) throws TaskCommandException, ParseException {
        getTasks().addCommand(new Task101Command());
        getTasks().runTasks();
    }
}