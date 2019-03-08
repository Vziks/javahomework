package info.vziks.homework1;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Class Task1CommandTest
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Task1CommandTest {

    @Test
    public void testTask1CommandEquals() {
        Task1Command classTask1CommandTest = new Task1Command();

        Random rand = new Random(47);

        int height = rand.nextInt(100);
        int length = rand.nextInt(100);
        int width = rand.nextInt(100);

        assertEquals(27398, classTask1CommandTest.getSurfaceArea(height, length, width));
    }

    @Test
    public void testTask1CommandRandomEquals() {
        Task1Command classTask1CommandTest = new Task1Command();

        Random rand = new Random(1);

        classTask1CommandTest.setRand(rand);

        int height = rand.nextInt(50);
        int length = rand.nextInt(50);
        int width = rand.nextInt(50);

        assertEquals(9522, classTask1CommandTest.getSurfaceArea(height, length, width));
    }

}
