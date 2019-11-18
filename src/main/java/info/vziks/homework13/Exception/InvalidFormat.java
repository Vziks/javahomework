package info.vziks.homework13.Exception;

public class InvalidFormat extends Exception {
    @Override
    public String getMessage() {
        return "invalid form input data, example:\n 11/1\n, 25-6\n, 2+3\n, 4*5\n";
    }
}
