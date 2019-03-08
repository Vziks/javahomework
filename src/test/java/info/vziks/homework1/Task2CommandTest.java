package info.vziks.homework1;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class Task2CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task2CommandTest {

    @Test
    public void testTask2CommandEquals() {
        Task2Command classTask2CommandTest = new Task2Command();

        Map<Pair<Integer, Integer>, Pair<Integer, Integer>> map = new HashMap<>();
        map.put(new Pair<>(10, 250), new Pair<>(15, 25));
        map.put(new Pair<>(15, 300), new Pair<>(20, 20));
        map.put(new Pair<>(6, 15), new Pair<>(5, 15));
        map.put(new Pair<>(4, 48), new Pair<>(10, 12));

        for (Map.Entry<Pair<Integer, Integer>, Pair<Integer, Integer>> entry : map.entrySet()) {

            assertEquals(
                    classTask2CommandTest.remainderSquare(
                            entry.getKey().getKey(),
                            entry.getValue().getKey(),
                            entry.getValue().getValue()
                    ),
                    entry.getKey().getValue().intValue());
        }
    }
}