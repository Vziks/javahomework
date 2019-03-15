package info.vziks.homework3;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Class Task31CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task31CommandTest {
    @Test
    public void testTask31Command() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String[][] arrStr = {
                {"2 4 6 8 10 12 14 16 18 20", "horizontalArray"},
                {"2\n" +
                        "4\n" +
                        "6\n" +
                        "8\n" +
                        "10\n" +
                        "12\n" +
                        "14\n" +
                        "16\n" +
                        "18\n" +
                        "20\n", "verticallyArray"}
        };

        Task31Command classTask31CommandTest = new Task31Command();

        for (String[] item :
                arrStr) {
            Method method = classTask31CommandTest.getClass().getMethod(item[1]);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));
            method.invoke(classTask31CommandTest);

            assertEquals(item[0], outContent.toString());

        }


    }
}
