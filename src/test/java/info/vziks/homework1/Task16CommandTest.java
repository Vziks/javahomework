package info.vziks.homework1;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class Task16CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task16CommandTest {

    @Test
    public void testTask16CommandEquals() {
        Task16Command classTask16CommandTest = new Task16Command();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(208, 8);
        map.put(477, 7);
        map.put(392, 9);
        map.put(123, 3);
        map.put(532, 5);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            assertEquals(entry.getValue().intValue(), classTask16CommandTest.getMaxWithByte(entry.getKey()));
            assertEquals(entry.getValue().intValue(), classTask16CommandTest.getMaxWithString(entry.getKey()));
            assertEquals(entry.getValue().intValue(), classTask16CommandTest.getMaxWithRecursive(entry.getKey()));
        }
    }

}
