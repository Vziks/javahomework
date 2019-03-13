package info.vziks.homework1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task14CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task14CommandTest {

    @Test
    public void testTask14CommandEquals() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Task14Command classTask14CommandTest = new Task14Command();
        classTask14CommandTest.execute();
        assertEquals("N closer\n", outContent.toString());
    }

    @Test
    public void testTask14CommandRandomEquals() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Task14Command classTask14CommandTest = new Task14Command();

        Random rand = new Random(1);
        classTask14CommandTest.setRand(rand);
        classTask14CommandTest.setTen(20);
        classTask14CommandTest.setN(rand.nextInt(classTask14CommandTest.getTen()));
        classTask14CommandTest.setM(classTask14CommandTest.getTen() + rand.nextInt(40 - classTask14CommandTest.getTen()));

        classTask14CommandTest.execute();

        assertEquals("M closer\n", outContent.toString());
    }

    @Test
    public void testTask14CommandOneEquals() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        Task14Command classTask14CommandTest = new Task14Command();

        Random rand = new Random(1);
        classTask14CommandTest.setRand(rand);
        classTask14CommandTest.setTen(20);
        classTask14CommandTest.setN(classTask14CommandTest.getTen());
        classTask14CommandTest.setM(classTask14CommandTest.getTen() + rand.nextInt(40 - classTask14CommandTest.getTen()));

        classTask14CommandTest.execute();

        assertEquals("M or N equals 20\n", outContent.toString());
    }

}
