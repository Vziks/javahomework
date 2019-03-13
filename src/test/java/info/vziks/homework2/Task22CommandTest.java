package info.vziks.homework2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class Task22CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task22CommandTest {

    @Test
    public void testTask22Command() {

        int[][] tempArray = {
                {90, 5},
                {90, 7},
                {180, 8},
        };

        String[] tempStringArray = {
                "90,85,80,75,70,65,60,55,50,45,40,35,30,25,20,15,10,5,0\n",
                "90,83,76,69,62,55,48,41,34,27,20,13,6\n",
                "180,172,164,156,148,140,132,124,116,108,100,92,84,76,68,60,52,44,36,28,20,12,4\n",
        };

        Task22Command classTask22CommandTest = new Task22Command();

        for (int i = 0; i < tempArray.length; i++) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            classTask22CommandTest.setCountStart(tempArray[i][0]);
            classTask22CommandTest.setStep(tempArray[i][1]);
            classTask22CommandTest.getResult();

            assertEquals(tempStringArray[i], outContent.toString());
        }

    }
}
