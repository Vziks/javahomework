package info.vziks.homework2;

import info.vziks.Command;

/**
 * Class Task28Command
 *
 * @author Anton Prokhorov
 */
public class Task28Command implements Command {

    private int start;
    private int stop;
    private int number;

    public Task28Command(int start, int stop, int number) {
        this.start = start;
        this.stop = stop;
        this.number = number;
    }

    public Task28Command() {
        this.start = 1;
        this.stop = 50000;
        this.number = 2;
    }

    @Override
    public void execute() {
        System.out.printf("Number of replacement plates %d \n", countNameplates());
    }

    public int countNameplates() {

        int count = 0;
        for (int i = getStart(); i < getStop(); i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == getNumber()) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
