package info.vziks.exceptions;

import info.vziks.App;
import org.junit.Test;

/**
 * Class TaskCommandExceptionTest
 *
 * @author Anton Prokhorov
 */
public class TaskCommandExceptionTest {

    @Test
    public void testForExceptions() {
        try {
            if (true) throw new TaskCommandException();
        } catch (TaskCommandException taskCommandExeption) {
            //ignore, this exception is expected.
        }
    }


    @Test
    public void testForExceptions1() {
        try {
            if (true) throw new TaskCommandException("Exception!");
        } catch (TaskCommandException taskCommandExeption) {
            //ignore, this exception is expected.
        }
    }
}
