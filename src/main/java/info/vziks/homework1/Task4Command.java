package info.vziks.homework1;

import java.util.Random;

/**
 * Class Task4Command
 *
 * @author Anton Prokhorov
 */
public class Task4Command implements Command {

    private Random rand = new Random(47);
    private double m = 8.5;
    private double n = 11.45;
    private int ten = 10;

    @Override
    public void execute() {
        if (getM() == getTen() || getN() == getTen()) {
            System.out.println("M or N equals " + getTen());
        } else {
            System.out.println(Math.abs(getTen() - getN()) > Math.abs(getTen() - getM()) ? "M closer" : "N closer");
        }
    }

    /**
     * Gets m.
     *
     * @return the m
     */
    public double getM() {
        return m;
    }

    /**
     * Sets m.
     *
     * @param m the m
     */
    public void setM(double m) {
        this.m = m;
    }

    /**
     * Gets n.
     *
     * @return the n
     */
    public double getN() {
        return n;
    }

    /**
     * Sets n.
     *
     * @param n the n
     */
    public void setN(double n) {
        this.n = n;
    }

    /**
     * Gets ten.
     *
     * @return the ten
     */
    public int getTen() {
        return ten;
    }

    /**
     * Sets ten.
     *
     * @param ten the ten
     */
    public void setTen(int ten) {
        this.ten = ten;
    }

    /**
     * Gets rand.
     *
     * @return the rand
     */
    public Random getRand() {
        return rand;
    }

    /**
     * Sets rand.
     *
     * @param rand the rand
     */
    public void setRand(Random rand) {
        this.rand = rand;
    }
}
