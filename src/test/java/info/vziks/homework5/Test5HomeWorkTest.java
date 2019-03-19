package info.vziks.homework5;

import javafx.util.Pair;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Test5HomeWorkTest {

    @Test
    public void testTest5HomeWorkTest() {

        Map<Pair<Integer, Integer>, Pair<String, String>> map = new HashMap<>();

        map.put(new Pair<>(20, 15), new Pair<>("-", "Result :5.0\n"));
        map.put(new Pair<>(30, 70), new Pair<>("+", "Result :100.0\n"));
        map.put(new Pair<>(20, 2), new Pair<>("*", "Result :40.0\n"));
        map.put(new Pair<>(15, 3), new Pair<>("/", "Result :5.0\n"));

        HomeWork5Main.init();

        for (Map.Entry<Pair<Integer, Integer>, Pair<String, String>> entry : map.entrySet()) {

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            HomeWork5Main.getResult(
                    entry.getValue().getKey().charAt(0),
                    entry.getKey().getKey(),
                    entry.getKey().getValue()
            );

            assertEquals(entry.getValue().getValue(), outContent.toString());
        }
    }
}
