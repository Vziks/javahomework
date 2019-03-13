package info.vziks.homework2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class Task26CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task26CommandTest {

    @Test
    public void testTask26Command() {
        int[][] arrayTest = {
                {1_000, 999_999, 55250},
                {20_000, 50_000, 1243}
        };

        for (int i = 0; i < arrayTest.length; i++) {
            Task26Command task26Command = new Task26Command(arrayTest[i][0], arrayTest[i][1]);
            task26Command.countTickets();
            assertEquals(arrayTest[i][2], task26Command.getCount());
        }

    }
}
