package info.vziks.homework1;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class Task12CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task12CommandTest {

    @Test
    public void testTask12CommandEquals() {
        Task12Command classTask12CommandTest;

        Map<Pair<Integer, Integer>, String> map = new HashMap<>();
        map.put(new Pair<>(20000, 8), "47040");
        map.put(new Pair<>(20000, 16), "4E20");
        map.put(new Pair<>(20000, 2), "100111000100000");

        Map<Pair<String, Integer>, Pair<Integer, String>> map2 = new HashMap<>();
        map2.put(new Pair<>("100111000100000", 10), new Pair<>(2, "20000"));
        map2.put(new Pair<>("4E20", 10), new Pair<>(16, "20000"));
        map2.put(new Pair<>("47040", 10), new Pair<>(8, "20000"));

        for (Map.Entry<Pair<Integer, Integer>, String> entry : map.entrySet()) {
            classTask12CommandTest = new Task12Command(entry.getKey().getKey(), entry.getKey().getValue());
            assertEquals(
                    classTask12CommandTest.convert(),
                    entry.getValue());
        }

        for (Map.Entry<Pair<String, Integer>, Pair<Integer, String>> entry2 : map2.entrySet()) {
            classTask12CommandTest = new Task12Command(
                    entry2.getKey().getKey(),
                    entry2.getKey().getValue(),
                    entry2.getValue().getKey()

            );

            assertEquals(
                    classTask12CommandTest.convert(),
                    entry2.getValue().getValue());
        }
    }
}
