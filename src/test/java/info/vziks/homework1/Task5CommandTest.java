package info.vziks.homework1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task5CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task5CommandTest {

    @Test
    public void testTask5CommandRandomEquals() {


        Task5Command classTask5CommandTest = new Task5Command();

        Map<Integer, String> map = new HashMap<>();
        map.put(4, "The equation has no real roots!\n");
        map.put(47, "The roots of an equation.: x1 = -0.06417460081172317, x2 = -1.4048151690092487\n");
        map.put(47289482, "Equation has a one root: x = -0.9130434782608696\n");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            Random rand = new Random(entry.getKey());
            classTask5CommandTest.setRand(rand);
            classTask5CommandTest.setA(classTask5CommandTest.rnd());
            classTask5CommandTest.setB(classTask5CommandTest.rnd());
            classTask5CommandTest.setC(classTask5CommandTest.rnd());

            classTask5CommandTest.execute();

            assertEquals(entry.getValue(), outContent.toString());
        }
    }
}
