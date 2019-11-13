package info.vziks.utils;

import info.vziks.exceptions.TaskCommandException;

import java.io.IOException;
import java.text.ParseException;

/**
 * Interface Command
 *
 * @author Anton Prokhorov
 */
public interface Command {
    void execute() throws TaskCommandException, ParseException, IOException;
}
