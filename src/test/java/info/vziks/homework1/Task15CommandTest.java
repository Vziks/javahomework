package info.vziks.homework1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Class Task15CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task15CommandTest {

    @Test
    public void testTask15CommandRandomEquals() {

        Task15Command classTask15CommandTest = new Task15Command();

        Map<Integer, String> map = new HashMap<>();
        map.put(4, "The equation has no real roots!\n");
        map.put(47, "The roots of an equation.: x1 = -0.06417460081172317, x2 = -1.4048151690092487\n");
        map.put(47289482, "Equation has a one root: x = -0.9130434782608696\n");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            Random rand = new Random(entry.getKey());
            classTask15CommandTest.setRand(rand);
            classTask15CommandTest.setA(classTask15CommandTest.rnd());
            classTask15CommandTest.setB(classTask15CommandTest.rnd());
            classTask15CommandTest.setC(classTask15CommandTest.rnd());

            classTask15CommandTest.execute();

            assertEquals(entry.getValue(), outContent.toString());
        }
    }
}
