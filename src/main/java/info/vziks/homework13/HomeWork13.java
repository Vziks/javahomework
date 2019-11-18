package info.vziks.homework13;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork13 extends HomeWorkMain {
    public static void main(String[] args) throws TaskCommandException, IOException, ParseException {
//        getTasks().addCommand(new Task131Command());
//        getTasks().addCommand(new Task132Command());
        getTasks().addCommand(new Task133Command());
        getTasks().runTasks();
    }
}
