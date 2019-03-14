package info.vziks.homework3;

import info.vziks.utils.Command;

/**
 * Class Task31Command
 *
 * @author Anton Prokhorov
 */
public class Task31Command implements Command {

    private int[] tempArr = new int[10];

    public Task31Command() {
        init();
    }

    @Override
    public void execute() {
        horizontalArray();
        verticallyArray();
    }

    public void init() {
        int i = 2;
        while (i <= 20) {
            tempArr[i / 2 - 1] = i;
            i += 2;
        }
        setTempArr(tempArr);
    }

    public void horizontalArray() {
        for (int item :
                getTempArr()) {
            System.out.print(item + " ");
        }
    }

    public void verticallyArray() {
        for (int item :
                getTempArr()) {
            System.out.println(item);

        }
    }

    public int[] getTempArr() {
        return tempArr;
    }

    public void setTempArr(int[] tempArr) {
        this.tempArr = tempArr;
    }
}
