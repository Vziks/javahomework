package info.vziks.homework2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class Task29CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task29CommandTest {

    @Test
    public void testTask29Command() {

        int[][] ArrayTest = {
                {1, 50_000, 25435},
                {20_000, 50_000, 17362},
                {10_000, 40_000, 11754}
        };

        for (int i = 0; i < ArrayTest.length; i++) {
            Task29Command task29Command = new Task29Command(ArrayTest[i][0], ArrayTest[i][1]);
            assertEquals(ArrayTest[i][2], task29Command.countNumberOfVehicles());
        }
    }
}
