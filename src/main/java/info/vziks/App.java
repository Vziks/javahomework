package info.vziks;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework1.HomeWork1;
import info.vziks.homework2.HomeWork2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    }
}
