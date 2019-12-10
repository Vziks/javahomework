package info.vziks.homework16;

import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork16 extends HomeWorkMain {
    public static void main(String[] args) throws IOException, ParseException {
        getTasks().addCommand(new Task161Command());
        getTasks().runTasks();
    }
}
