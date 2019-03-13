package info.vziks.homework2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class Task23CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task23CommandTest {
    @Test
    public void testTask23Command() {

        int[][] testArray = {
                {2, 20},
                {3, 10}
        };

        String[] testStringArray = {
                "2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576\n",
                "3,9,27,81,243,729,2187,6561,19683,59049\n"
        };

        Task23Command classTask23CommandTest = new Task23Command();

        for (int i = 0; i < testArray.length; i++) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            classTask23CommandTest.setStart(testArray[i][0]);
            classTask23CommandTest.setCountNum(testArray[i][1]);
            classTask23CommandTest.exponentiation();

            assertEquals(testStringArray[i], outContent.toString());

        }

    }


}
