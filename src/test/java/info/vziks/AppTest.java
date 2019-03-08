package info.vziks;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class AppTest {

    @Test
    public void testAppOutPut() {
        String[] args = null;
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        App classUnderTest = new App("Hello world");

        classUnderTest.main(args);
        assertEquals("Hello world\n", outContent.toString());
    }

    @Test
    public void testAppGetStr() {
        App classUnderTest = new App("Hello world");
        assertNotNull("app should have a greeting", classUnderTest.getStr());
    }


    @Test
    public void testAppContentEquals() {
        App classUnderTest = new App("Content Equals");
        assertTrue(classUnderTest.getStr().contentEquals("Content Equals"));
    }
}
