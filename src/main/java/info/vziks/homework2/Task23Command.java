package info.vziks.homework2;

import info.vziks.utils.Command;
import info.vziks.exceptions.TaskCommandException;

/**
 * Class Task23Command
 *
 * @author Anton Prokhorov
 */
public class Task23Command implements Command {

    private int start = 2;
    private int countNum = 20;

//    public Task23Command(int start) throws TaskCommandExeption {
//        if (start <= 1) throw new TaskCommandExeption();
//        this.start = start;
//        this.start = start;
//    }

    public Task23Command(int start, int countNum) throws TaskCommandException{
        if (start <= 1) throw new TaskCommandException();
        this.start = start;
        this.countNum = countNum;
    }

    public Task23Command() {
        this.start = 2;
        this.countNum = 20;
    }

    @Override
    public void execute() {
        exponentiation();
    }

    public void exponentiation() {
        for (int i = 1; i <= getCountNum(); ++i) {
            System.out.print((int) Math.pow(getStart(), i) + ((i != getCountNum()) ? "," : "\n"));
        }
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }
}
