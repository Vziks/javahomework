package info.vziks.homework3;

import info.vziks.utils.Command;

import java.util.Random;
import java.util.Scanner;

/**
 * Class Task34Command
 *
 * @author Anton Prokhorov
 */
public class Task34Command implements Command {


    private int[] tempArr;
    private int leftSum;
    private int rightSum;
    private Random rnd = new Random(47);

    @Override
    public void execute() {

        Scanner stdIn = new Scanner(System.in).useDelimiter("\n");

        int arrLength;

        do {
            System.out.println("Please enter a positive number!");
            while (!stdIn.hasNextInt()) {
                System.out.println("That not a number!");
                stdIn.next();
            }
            arrLength = stdIn.nextInt();
        } while (arrLength <= 0);

        init(arrLength);
        fillArr();
        for (int item:
             getTempArr()) {
            System.out.print(item + " ");
        }

        calculations();
        conditions();
    }

    public void conditions() {
        System.out.println((getLeftSum() == getRightSum() ? "\n" +
                "The sums of the modules are equal" : (getLeftSum() > getRightSum() ? "\n" +
                "The sum of the modules of the left half is greater than the right" : "\n" +
                "The sum of the modules of the right half is greater than the left")));
    }

    public void init(int arrLength) {
        setTempArr(new int[arrLength]);
    }

    public void calculations() {
        for (int i = 0; i < getTempArr().length / 2; i++) {
            leftSum += Math.abs(getTempArr()[i]);
            rightSum += Math.abs(getTempArr()[i + getTempArr().length / 2]);
        }
    }

    public void fillArr() {
        for (int i = 0; i < getTempArr().length; i++) {
            getTempArr()[i] = rnd.nextInt(11) - 5;
        }
    }

    public int[] getTempArr() {
        return tempArr;
    }

    public void setTempArr(int[] tempArr) {
        this.tempArr = tempArr;
    }

    public int getLeftSum() {
        return leftSum;
    }

    public int getRightSum() {
        return rightSum;
    }

}
