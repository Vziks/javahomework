package info.vziks.homework2;

import info.vziks.utils.Command;

/**
 * Class Task29Command
 *
 * @author Anton Prokhorov
 */
public class Task29Command implements Command {
    private int start;
    private int stop;

    public Task29Command(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public Task29Command() {
        this.start = 1;
        this.stop = 999999;
    }

    @Override
    public void execute() {
        System.out.printf("Number of vehicles %d ", countNumberOfVehicles());
    }

    public int countNumberOfVehicles() {

        int count = 0;
        for (int i = getStart(); i < getStop(); i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 4 || (j % 10 == 3) && ((j / 10) % 10 == 1)) {
                    count++;
                    break;
                }
                j /= 10;
            }
        }
        return count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

}
