package info.vziks.homework14;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework14.FilesManipulation.AppFiles;
import info.vziks.utils.Command;

import java.io.IOException;
import java.text.ParseException;

public class Task142Command implements Command {
    @Override
    public void execute() throws TaskCommandException, ParseException, IOException {
        AppFiles appFiles = new AppFiles("wp.txt");
        appFiles.writeToFiles();
        appFiles.writeToRandomAccessFiles();
        appFiles.mergeToFiles();
    }
}
