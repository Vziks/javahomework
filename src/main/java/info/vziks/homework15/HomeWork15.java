package info.vziks.homework15;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;


public class HomeWork15 extends HomeWorkMain {
    public static void main(String[] args) throws IOException, ParseException {
        getTasks().addCommand(new Task151Command());
        getTasks().addCommand(new Task152Command());
        getTasks().addCommand(new Task153Command());
        getTasks().runTasks();
    }
}
