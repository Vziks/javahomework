package info.vziks.homework2;

import info.vziks.Command;

/**
 * Class Task26Command
 *
 * @author Anton Prokhorov
 */
public class Task26Command implements Command {

    private int start;
    private int stop;
    private int count = 0;

    public Task26Command(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public Task26Command() {
        this.start = 1_000;
        this.stop = 999_999;
    }

    @Override
    public void execute() {
        countTickets();
        System.out.printf("Happy tickets %d in the range [%d, %d]\n", getCount(), getStart(), getStop());
    }

    public void countTickets() {

        int i;
        int count;
        for (i = getStart(), count = 0; i < getStop(); i++) {
            if (isEquality(i)) {
                count++;
            }
        }
        setCount(count);
    }

    public boolean isEquality(int number) {

        return sumOfDigits(number % 1000) == sumOfDigits(number / 1000);
    }

    private static int sumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
