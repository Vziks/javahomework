package info.vziks.homework13;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework13.Exception.ArrayException;
import info.vziks.utils.Command;

public class Task133Command implements Command {

    @Override
    public void execute() throws TaskCommandException {
        ArrayException arrayException = new ArrayException();

        int i = 1;
        for (RuntimeException runtimeException :
                arrayException.getArrayListException()) {
            System.out.printf("%d - %s\n", i++, runtimeException);
        }
    }
}
