package info.vziks;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework1.HomeWork1;
import info.vziks.homework2.HomeWork2;
import info.vziks.homework3.HomeWork3;


/**
 * Main class
 */
public class App {

    /**
     * Entry point application
     */
    public static void main(String[] args) throws TaskCommandException {
        HomeWork1.main(args);
        HomeWork2.main(args);
        HomeWork3.main(args);
    }
}
