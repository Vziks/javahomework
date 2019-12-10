package info.vziks.homework16;

import info.vziks.homework16.war.MultiParser;
import info.vziks.utils.Command;

import java.io.IOException;

public class Task161Command implements Command {
    @Override
    public void execute() {
        MultiParser multiParser = null;

        try {
            multiParser = new MultiParser("wp.txt");
            multiParser.start();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        multiParser.printTop100Words();
    }
}
