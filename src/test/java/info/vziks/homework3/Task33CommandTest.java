package info.vziks.homework3;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task33CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task33CommandTest {
    @Test
    public void testTask32Command() {

        int[][] arrInt = {{7, 47}, {9, 100}, {6, 20}};

        Task33Command classTask33CommandTest = new Task33Command();

        for (int[] item :
                arrInt) {
            classTask33CommandTest.setRnd(new Random(item[1]));
            classTask33CommandTest.init();
            assertEquals(item[0], classTask33CommandTest.getCountOddNumbers());
        }
    }
}
