package info.vziks;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
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
