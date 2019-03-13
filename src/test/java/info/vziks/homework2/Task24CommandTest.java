package info.vziks.homework2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class Task24CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task24CommandTest {

    @Test
    public void testTask24Command() {
        int[] numbers = {
                2539,
                2243,
                2210,
                1291,
                4200
        };

        String[] testStringArray = {
                "The number 2539 is prime by lib\n" +
                        "The number 2539 is prime by for\n",
                "The number 2243 is prime by lib\n" +
                        "The number 2243 is prime by for\n",
                "The number 2210 is not prime by lib\n" +
                        "The number 2210 is not prime by for\n",
                "The number 1291 is prime by lib\n" +
                        "The number 1291 is prime by for\n",
                "The number 4200 is not prime by lib\n" +
                        "The number 4200 is not prime by for\n"
        };

        Task24Command classTask24CommandTest = new Task24Command();

        for (int i = 0; i < numbers.length; i++) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            classTask24CommandTest.setPrime(numbers[i]);

            classTask24CommandTest.isProbablePrimeByLib();
            classTask24CommandTest.isProbablePrimeByFor();

            assertEquals(testStringArray[i], outContent.toString());
        }
    }
}
