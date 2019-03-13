package info.vziks.homework2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class Task27CommandTest
 *
 * @author Anton Prokhorov
 */
public class Task27CommandTest {

    @Test
    public void testTask27Command() {
        Task27Command task27Command = new Task27Command();
        assertEquals(16, task27Command.countTimeEquals());
    }
}
