package info.vziks.homework1;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task3CommandTest
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Task3CommandTest {

    @Test
    public void testTask3CommandEquals() {
        Task3Command classTask3CommandTest = new Task3Command();

        assertEquals(1485, classTask3CommandTest.areaDifference(classTask3CommandTest.getEllipseSquareDm(), classTask3CommandTest.getEllipseSquareDm()));
    }

    @Test
    public void testTask3CommandRandomEquals() {
        Task3Command classTask3CommandTest = new Task3Command();

        Random rand = new Random(1);

        classTask3CommandTest.setEllipseSquareDm(rand.nextInt(30));
        classTask3CommandTest.setEllipseSquareSm(rand.nextInt(700));

        assertEquals(1412, classTask3CommandTest.areaDifference(classTask3CommandTest.getEllipseSquareDm(), classTask3CommandTest.getEllipseSquareSm()));
    }
}
