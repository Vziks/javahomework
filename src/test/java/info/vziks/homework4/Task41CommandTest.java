package info.vziks.homework4;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework4.list.DoublyLinkList;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Task41CommandTest {
    @Test
    public void testTask41Command() throws TaskCommandException {
        String check = "8 3 3 1 3 1 5 9 8 0 2 8 8 3 1 5 9 5 9\n";

        Task41Command classTask41CommandTest = new Task41Command();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        classTask41CommandTest.execute();

        assertEquals(check, outContent.toString());
    }


    @Test(expected = TaskCommandException.class)
    public void testTask41CommandRandomExeptionExpected2() throws TaskCommandException {

        Random rnd = new Random(47);
        DoublyLinkList list = new DoublyLinkList();
        for (int i = 0; i < 10; i++) {
            list.add(rnd.nextInt(10));
        }

        list.deleteByIndex(240);
    }
}
