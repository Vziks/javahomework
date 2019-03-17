package info.vziks.utils;

import info.vziks.exceptions.TaskCommandException;

/**
 * Interface Command
 *
 * @author Anton Prokhorov
 */
public interface Command {
    void execute() throws TaskCommandException;
}
