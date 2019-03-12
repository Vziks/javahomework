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

        assertEquals(1485, classTask13CommandTest.areaDifference(classTask13CommandTest.getEllipseSquareDm(), classTask13CommandTest.getEllipseSquareDm()));
    }

    @Test
    public void testTask13CommandRandomEquals() {
        Task13Command classTask13CommandTest = new Task13Command();

        Random rand = new Random(1);

        classTask13CommandTest.setEllipseSquareDm(rand.nextInt(30));
        classTask13CommandTest.setEllipseSquareSm(rand.nextInt(700));

        assertEquals(1412, classTask13CommandTest.areaDifference(classTask13CommandTest.getEllipseSquareDm(), classTask13CommandTest.getEllipseSquareSm()));
    }
}
