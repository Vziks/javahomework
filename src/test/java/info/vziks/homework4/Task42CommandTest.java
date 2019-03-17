package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Task42CommandTest  {
    @Test
    public void testTask41Command() {
        String check = "Circle square:7853.981633974483\n" +
                "Circle perimeter:314.1592653589793\n" +
                "Circle square:28952.917895483533\n" +
                "Circle perimeter:603.1857894892403\n" +
                "Circle square:6082.12337734984\n" +
                "Circle perimeter:276.46015351590177\n" +
                "Triangle square:9.0\n" +
                "Triangle perimeter:106.93790046167325\n" +
                "Triangle square:70.0\n" +
                "Triangle perimeter:150.19923984838903\n" +
                "Triangle square:258.5\n" +
                "Triangle perimeter:188.7339544791389\n" +
                "Rectangle square:1680.0\n" +
                "Rectangle perimeter:164.0\n" +
                "Rectangle square:1494.0\n" +
                "Rectangle perimeter:202.0\n" +
                "Rectangle square:2730.0\n" +
                "Rectangle perimeter:214.0\n";

        Task42Command classTask42CommandTest = new Task42Command();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        classTask42CommandTest.execute();

        assertEquals(check, outContent.toString());
    }
}
