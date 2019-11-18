package info.vziks.homework12;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.utils.HomeWorkMain;

import java.io.IOException;
import java.text.ParseException;

public class HomeWork12 extends HomeWorkMain {


    /**
     * @param args
     * @throws ParseException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, ParseException {
        getTasks().addCommand(new Task121Command());
        getTasks().runTasks();
    }
}