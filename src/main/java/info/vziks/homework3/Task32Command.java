package info.vziks.homework3;

import info.vziks.utils.Command;

import java.util.Arrays;

/**
 * Class Task32Command
 *
 * @author Anton Prokhorov
 */
public class Task32Command implements Command {

    private int[] tempArr = {};

    public Task32Command() {
        init();
    }

    public void init() {
        int i = 0;
        while (i <= 99) {
            if (i % 2 > 0) {
                tempArr = addElement(tempArr, i);
            }
            i += 1;
        }
        setTempArr(tempArr);
    }

    @Override
    public void execute() {
        normalOrder();
        reverseOrder();
    }

    public void normalOrder() {
        for (int item :
                getTempArr()) {
            System.out.print(item + " ");
        }
    }

    public void reverseOrder() {
        System.out.println();
        for (int i = getTempArr().length - 1; i >= 0; i--) {
            System.out.print(getTempArr()[i] + " ");
        }
    }

    public int[] getTempArr() {
        return tempArr;
    }

    public void setTempArr(int[] tempArr) {
        this.tempArr = tempArr;
    }

    public static int[] addElement(int[] inArr, int num) {
        inArr = Arrays.copyOf(inArr, inArr.length + 1);
        inArr[inArr.length - 1] = num;
        return inArr;
    }
}
