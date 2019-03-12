package info.vziks.homework2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class Task21CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task21CommandTest {
    @Test
    public void testTask21Command() {

        Task21Command classTask21CommandTest = new Task21Command();

        int[][] tempArray = {
                {3, 9, -1},
                {2, 4, 3},
                {7, 0, -5},
                {4, -7, 9},
                {3, 2, 6},
                {4, 8, 7},
                {-7, 10, 7},
                {3, 2, -10},
        };
        String[] tempStringArray = {
                "Input: Task21{a=3, b=9, c=-1}\n" +
                        "Output:Task21{a=-1, b=3, c=9}\n",
                "Input: Task21{a=2, b=4, c=3}\n" +
                        "Output:Task21{a=2, b=3, c=4}\n",
                "Input: Task21{a=7, b=0, c=-5}\n" +
                        "Output:Task21{a=-5, b=0, c=7}\n",
                "Input: Task21{a=4, b=-7, c=9}\n" +
                        "Output:Task21{a=-7, b=4, c=9}\n",
                "Input: Task21{a=3, b=2, c=6}\n" +
                        "Output:Task21{a=2, b=3, c=6}\n",
                "Input: Task21{a=4, b=8, c=7}\n" +
                        "Output:Task21{a=4, b=7, c=8}\n",
                "Input: Task21{a=-7, b=10, c=7}\n" +
                        "Output:Task21{a=-7, b=7, c=10}\n",
                "Input: Task21{a=3, b=2, c=-10}\n" +
                        "Output:Task21{a=-10, b=2, c=3}\n"};

        for (int i = 0; i < tempArray.length; i++) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            classTask21CommandTest.setA(tempArray[i][0]);
            classTask21CommandTest.setB(tempArray[i][1]);
            classTask21CommandTest.setC(tempArray[i][2]);
            classTask21CommandTest.setX(0);
            classTask21CommandTest.increasingSequence();

            assertEquals(tempStringArray[i], outContent.toString());

        }
    }
}
