package info.vziks.homework2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class Task28CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task28CommandTest {
    @Test
    public void testTask28Command() {

        int[][] ArrayTest = {
                {1, 50_000, 2, 23756},
                {20_000, 50_000, 3, 16878},
                {10_000, 40_000, 4, 10317}
        };

        for (int i = 0; i < ArrayTest.length; i++) {
            Task28Command task28Command = new Task28Command(ArrayTest[i][0], ArrayTest[i][1], ArrayTest[i][2]);
            assertEquals(ArrayTest[i][3], task28Command.countNameplates());
        }
    }
}
