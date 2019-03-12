package info.vziks.homework2;

import info.vziks.Command;

/**
 * Class Task27Command
 *
 * @author Anton Prokhorov
 */
public class Task27Command implements Command {


    @Override
    public void execute() {
        System.out.printf("Coincidences %d\n", countTimeEquals());
    }

    public int countTimeEquals() {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 52; j++) {
                if ((i % 10) == (j / 10) && (i / 10) == (j % 10)) {
                    count++;
                }
            }
        }
        return count;
    }
}
