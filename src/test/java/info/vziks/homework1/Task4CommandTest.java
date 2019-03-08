package info.vziks.homework1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task4CommandTest
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Task4CommandTest {

    @Test
    public void testTask4CommandEquals() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Task4Command classTask4CommandTest = new Task4Command();
        classTask4CommandTest.execute();
        assertEquals("M closer\n", outContent.toString());
    }

    @Test
    public void testTask4CommandRandomEquals() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Task4Command classTask4CommandTest = new Task4Command();

        Random rand = new Random(1);
        classTask4CommandTest.setRand(rand);
        classTask4CommandTest.setTen(20);
        classTask4CommandTest.setN(rand.nextInt(classTask4CommandTest.getTen()));
        classTask4CommandTest.setM(classTask4CommandTest.getTen() + rand.nextInt(40 - classTask4CommandTest.getTen()));

        classTask4CommandTest.execute();

        assertEquals("M closer\n", outContent.toString());
    }
}
