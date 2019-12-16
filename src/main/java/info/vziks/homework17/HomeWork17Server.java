package info.vziks.homework17;

import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork17Server extends HomeWorkMain {
    public static void main(String[] args) throws IOException, ParseException {
        getTasks().addCommand(new Task171Command());
        getTasks().runTasks();
    }
}
