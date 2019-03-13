package info.vziks.homework2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Class Task25CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task25CommandTest {

    @Test
    public void testTask25Command() {

        int[] testArray = {
                20,
                17,
                8,
                3
        };

        String[] testStringArray = {
                "[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765]\n",
                "[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597]\n",
                "[1, 1, 2, 3, 5, 8, 13, 21]\n",
                "[1, 1, 2]\n",
        };

        List<Task25Command> commands = new LinkedList<>();

        for (int i = 0; i < testArray.length; i++) {
            commands.add(new Task25Command(testArray[i]));
        }
        int i = 0;
        for (Task25Command item : commands) {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outContent));

            item.execute();

            assertEquals(testStringArray[i], outContent.toString());

            i++;
        }

    }
}
