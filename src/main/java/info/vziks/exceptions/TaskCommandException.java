package info.vziks.exceptions;

/**
 * Class TaskCommandExeption
 *
 * @author Anton Prokhorov
 */
public class TaskCommandException extends RuntimeException {

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
