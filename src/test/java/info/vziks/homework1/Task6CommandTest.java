package info.vziks.homework1;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class Task6CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task6CommandTest {

    @Test
    public void testTask6CommandEquals() {
        Task6Command classTask6CommandTest = new Task6Command();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(208, 8);
        map.put(477, 7);
        map.put(392, 9);
        map.put(123, 3);
        map.put(532, 5);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            assertEquals(entry.getValue().intValue(), classTask6CommandTest.getMaxWithByte(entry.getKey()));
            assertEquals(entry.getValue().intValue(), classTask6CommandTest.getMaxWithString(entry.getKey()));
            assertEquals(entry.getValue().intValue(), classTask6CommandTest.getMaxWithRecursive(entry.getKey()));
        }
    }

}
