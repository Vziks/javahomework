package info.vziks.homework13.Exception;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework1.Task11Command;

import java.util.*;

public class ArrayException {

    public static String str = "Hello from Jav";

    ArrayList<RuntimeException> arrayListException = new ArrayList<>();

    public ArrayException() {
        init();
    }

    public ArrayList<RuntimeException> getArrayListException() {
        return arrayListException;
    }

    private void init() {

        try {
            int num = Integer.parseInt("Java");
        } catch (NumberFormatException e) {
            arrayListException.add(e);
        }


        try {
            int a = 42 / 0;
        } catch (ArithmeticException e) {
            arrayListException.add(e);
        }

        try {
            int[] arr = new int[2];
            arr[4] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            arrayListException.add(e);
        }

        try {
            Objects.requireNonNull(ArrayException.class.getClassLoader().getResource("file.txt")).getFile();
        } catch (NullPointerException e) {
            arrayListException.add(e);
        }

        try {
            int arrSize = -8;
            int[] myArray = new int[arrSize];
        } catch (NegativeArraySizeException e) {
            arrayListException.add(e);
        }

        try {
            Number[] a = new Double[5];
            a[0] = 4;
        } catch (ArrayStoreException e) {
            arrayListException.add(e);
        }

        try {
            String str = "Java";
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            arrayListException.add(e);
        }

        try {
            Set hashSet = new HashSet();
            hashSet.iterator().next();
        } catch (NoSuchElementException e) {
            arrayListException.add(e);
        }

        try {
            Random rand = new Random(11166);
            new Task11Command(
                    rand,
                    rand.nextInt(100),
                    rand.nextInt(100)
            );
        } catch (TaskCommandException e) {
            arrayListException.add(e);
        }

    }
}
