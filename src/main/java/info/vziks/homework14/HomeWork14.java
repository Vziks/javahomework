package info.vziks.homework14;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework13.Task132Command;
import info.vziks.homework13.Task133Command;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork14 extends HomeWorkMain {
    public static void main(String[] args) throws TaskCommandException, IOException, ParseException {
        getTasks().addCommand(new Task141Command());
        getTasks().runTasks();
    }
}
