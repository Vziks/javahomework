package info.vziks.homework1;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task13CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task13CommandTest {

    @Test
    public void testTask13CommandEquals() {
        Task13Command classTask13CommandTest = new Task13Command();

        assertEquals("{1,2}{4+3}{2,1}{3+4}", classTask13CommandTest.find());
    }

    @Test
    public void testTask13CommandRandomEquals() {
        Random rand = new Random(1);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10); // storing random integers in an array
        }
        Task13Command classTask13CommandTest = new Task13Command(arr, 8);

        assertEquals("{0,3}{5+3}{4,5}{4+4}{4,4}{4+4}{5,4}{4+4}", classTask13CommandTest.find());
    }
}
