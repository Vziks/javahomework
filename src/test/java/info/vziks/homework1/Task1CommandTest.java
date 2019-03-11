package info.vziks.homework1;

import info.vziks.homework1.exceptions.Task1CommandExeption;
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
    public void testTask1CommandEquals() throws Task1CommandExeption {
        Task1Command classTask1CommandTest = new Task1Command();

        Random rand = new Random(47);

        int height = rand.nextInt(100);
        int length = rand.nextInt(100);
        int width = rand.nextInt(100);

        assertEquals(27398, classTask1CommandTest.getSurfaceArea(height, length, width));
    }

    @Test
    public void testTask1CommandRandomEquals() throws Task1CommandExeption {
        Task1Command classTask1CommandTest = new Task1Command();

        Random rand = new Random(1);

        classTask1CommandTest.setRand(rand);

        int height = rand.nextInt(50);
        int length = rand.nextInt(50);
        int width = rand.nextInt(50);

        assertEquals(9522, classTask1CommandTest.getSurfaceArea(height, length, width));
    }


    @Test
    public void testTask1CommandRandomExeption() {
        boolean thrown = false;
        Random rand = new Random(11166);

        try {
            new Task1Command(
                    rand,
                    rand.nextInt(100),
                    rand.nextInt(100),
                    rand.nextInt(100));
        } catch (Task1CommandExeption e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    @Test(expected = Task1CommandExeption.class)
    public void testTask1CommandRandomExeptionExpected() throws Task1CommandExeption {
        Random rand = new Random(11166);
        new Task1Command(
                new Random(11166),
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100));

    }

}
