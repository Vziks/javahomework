package info.vziks.homework1.exceptions;

/**
 * Class Task1CommandExeption
 *
 * @author Anton Prokhorov
 */
public class Task1CommandExeption extends Exception {

    public Task1CommandExeption() {
        super("Invalid argument");
    }

    public Task1CommandExeption(String message) {
        super(message);
    }

}
