package info.vziks.homework3;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Class Task34CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task34CommandTest {

    @Test
    public void testTask34Command() {

        String[][] arrInt = {
                {"22", "\nThe sum of the modules of the left half is greater than the right\n"},
                {"33", "\nThe sum of the modules of the right half is greater than the left\n"}
        };

        Task34Command classTask34CommandTest = new Task34Command();

        for (String[] item :
                arrInt) {
            classTask34CommandTest.init(new Integer(item[0]));
            classTask34CommandTest.fillArr();

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            classTask34CommandTest.calculations();
            classTask34CommandTest.conditions();

            assertEquals(item[1], outContent.toString());

        }
    }
}
