package info.vziks.homework2;

import info.vziks.Command;
import info.vziks.TaskCommands;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Task25Command
 *
 * @author Anton Prokhorov
 */
public class Task25Command implements Command {

    private int number;

    public Task25Command() {
        number = 11;
    }

    public Task25Command(int number) {
        this.number = number;
    }

    @Override
    public void execute() {
        System.out.println(fibonacchiList());
    }

    public List<Integer> fibonacchiList() {

        List<Integer> numbers = new LinkedList<>();
        int res = 0;
        int count = 0;
        while (count != getNumber()) {
            if (count == 0 || count == 1) {
                numbers.add(1);
                count++;
            } else {
                res = numbers.get(count - 1) + numbers.get(count - 2);
                numbers.add(res);
                count++;
            }
        }
        return numbers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
