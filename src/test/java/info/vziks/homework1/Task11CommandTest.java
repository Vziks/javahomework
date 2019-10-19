package info.vziks.homework1;


import info.vziks.exceptions.TaskCommandException;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Class Task11CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task11CommandTest {

    @Test
    public void testTask11CommandEquals() throws TaskCommandException {
        Task11Command classTask11CommandTest = new Task11Command();

        Random rand = new Random(47);

        int a = rand.nextInt(100);
        int b = rand.nextInt(100);

        assertEquals(1, classTask11CommandTest.getGcd(a, b));
    }

    @Test
    public void testTask11CommandRandomEquals() throws TaskCommandException {
        Task11Command classTask11CommandTest = new Task11Command();

        Random rand = new Random(1);

        classTask11CommandTest.setRand(rand);

        int a = rand.nextInt(100);
        int b = rand.nextInt(100);

        assertEquals(1, classTask11CommandTest.getGcd(a, b));
    }


    @Test
    public void testTask11CommandRandomExeption() {
        boolean thrown = false;
        Random rand = new Random(11166);

        try {
            new Task11Command(
                    rand,
                    rand.nextInt(100),
                    rand.nextInt(100)
            );
        } catch (TaskCommandException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    @Test(expected = TaskCommandException.class)
    public void testTask11CommandRandomExeptionExpected() throws TaskCommandException {
        Random rand = new Random(11166);
        new Task11Command(
                new Random(11166),
                rand.nextInt(100),
                rand.nextInt(100)
        );

    }

}
