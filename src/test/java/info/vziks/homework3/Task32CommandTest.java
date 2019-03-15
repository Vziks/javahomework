package info.vziks.homework3;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Class Task32CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task32CommandTest {
    @Test
    public void testTask32Command() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String[][] arrStr = {
                {"1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49 51 53 55 57 59 61 63 65 67 69 71 73 75 77 79 81 83 85 87 89 91 93 95 97 99", "normalOrder"},
                {"99 97 95 93 91 89 87 85 83 81 79 77 75 73 71 69 67 65 63 61 59 57 55 53 51 49 47 45 43 41 39 37 35 33 31 29 27 25 23 21 19 17 15 13 11 9 7 5 3 1", "reverseOrder"},
        };

        Task32Command classTask32CommandTest = new Task32Command();


        for (String[] item :
                arrStr) {
            Method method = classTask32CommandTest.getClass().getMethod(item[1]);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));
            method.invoke(classTask32CommandTest);

            assertEquals(item[0], outContent.toString());

        }

    }
}
