package info.vziks.homework3;

import info.vziks.utils.Command;

import java.util.Random;

/**
 * Class Task33Command
 *
 * @author Anton Prokhorov
 */
public class Task33Command implements Command {

    private int[] tempArr = new int[15];

    private Random rnd = new Random(47);

    public Task33Command() {
        init();
    }

    @Override
    public void execute() {
        System.out.println("Count even-numbered: " + getCountOddNumbers());
        horizontalArray();
    }

    public void init() {
        for (int i = 0, r = 0; i < tempArr.length; i++, r = rnd.nextInt(10)) {
            tempArr[i] = r;
        }
        setTempArr(tempArr);
    }

    public void horizontalArray() {
        for (int item :
                getTempArr()) {
            if (item % 2 == 0) {
                System.out.print(item + " ");
            }
        }
    }

    public int getCountOddNumbers() {
        int count = 0;
        for (int i = 0; i < getTempArr().length; i++) {
            if (getTempArr()[i] % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public int[] getTempArr() {
        return tempArr;
    }

    public void setTempArr(int[] tempArr) {
        this.tempArr = tempArr;
    }
}
