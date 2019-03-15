package info.vziks.homework2;

import info.vziks.utils.Command;

/**
 * Class Task21Command
 *
 * @author Anton Prokhorov
 */
public class Task21Command implements Command {

    private int a;
    private int b;
    private int c;
    private int x;

    @Override
    public void execute() {
        int[][] tempArray = {{3, 9, -1}, {2, 4, 3}, {7, 0, -5}};

        for (int i = 0; i < tempArray.length; i++) {
            setA(tempArray[i][0]);
            setB(tempArray[i][1]);
            setC(tempArray[i][2]);
            setX(0);
            increasingSequence();
        }

    }

    public void increasingSequence() {
        System.out.println("Input: " + toString());

        if (getA() > getB()) {
            setX(getA());
            setA(getB());
            setB(getX());
        }

        if (getB() > getC()) {
            setX(getC());
            setC(getB());
            setB(getX());
        }

        if (getA() > getB()) {
            setX(getA());
            setA(getB());
            setB(getX());
        }

        System.out.println("Output:" + toString());
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Task21{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
