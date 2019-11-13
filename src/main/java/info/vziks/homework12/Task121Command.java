package info.vziks.homework12;

import info.vziks.homework12.files.Parser;
import info.vziks.utils.Command;

import java.io.IOException;

public class Task121Command implements Command {
    @Override
    public void execute() throws IOException {

        Parser parser = new Parser("wp.txt");

        parser.init();

        parser.getTopTenWords();
        parser.getWordLengthStatistics();
        parser.getWordGroupStatistics();
        parser.getCharacterStatistics();
        parser.getProportionalRatio();

    }
}
