package info.vziks.homework2;

import info.vziks.utils.Command;

/**
 * Class Task22Command
 *
 * @author Anton Prokhorov
 */
public class Task22Command implements Command {

    private int countStart = 90;
    private int step = 5;

    @Override
    public void execute() {
        getResult();
    }

    public void getResult(){
        for (int i = getCountStart(); i >= 0; i-=getStep()) {
            System.out.print(i + ((i >= getStep()) ? ",":"\n"));
        }
    }

    public int getCountStart() {
        return countStart;
    }

    public void setCountStart(int countStart) {
        this.countStart = countStart;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
