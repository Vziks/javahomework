package info.vziks.homework4;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Task44CommandTest {
    @Test
    public void testTask44Command() {

        String check = "true\n" +
                "false\n" +
                "true\n" +
                "false\n" +
                "false\n" +
                "true\n" +
                "true\n" +
                "false\n";
        Task44Command classTask44CommandTest = new Task44Command();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        classTask44CommandTest.execute();

        assertEquals(check, outContent.toString());
    }
}
