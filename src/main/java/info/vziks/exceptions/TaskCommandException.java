package info.vziks.exceptions;

/**
 * Class TaskCommandExeption
 *
 * @author Anton Prokhorov
 */
public class TaskCommandException extends Exception {

    public TaskCommandException() {
        super("Invalid argument");
    }

    /**
     * @param message Input message for Exeption
     */
    public TaskCommandException(String message) {
        super(message);
    }

}
