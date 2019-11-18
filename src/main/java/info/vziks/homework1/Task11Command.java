package info.vziks.homework1;


import info.vziks.utils.Command;
import info.vziks.exceptions.TaskCommandException;

import java.util.Random;

/**
 * Class Task11Command
 *
 * @author Anton Prokhorov
 */
public class Task11Command implements Command {

    private Random rand;

    private int a;
    private int b;

    /**
     * @param rand Random object
     * @param a    Height cuboid. Must be positive.
     * @param b    Length cuboid. Must be positive.
     * @throws TaskCommandException if the a, b equals zero
     */
    public Task11Command(Random rand, int a, int b) {
        if (a == 0 || b == 0) {
            throw new TaskCommandException();
        }
        this.rand = rand;
        this.a = a;
        this.b = b;
    }

    /**
     * @throws TaskCommandException if method nextInt() of class {@code Random} generate not positive value
     */
    public Task11Command() {
        this.rand = new Random(47);
        this.a = rand.nextInt(100);
        this.b = rand.nextInt(100);
        if (a == 0 || b == 0) {
            throw new TaskCommandException();
        }
    }

    /**
     *
     */
    @Override
    public void execute() {
        System.out.printf("nod of a %d and b %d is %d\n",
                getA(),
                getB(),
                getGcd(getA(), getB())
        );
    }

    public int getGcd(int a, int b) {
        int nod = 0;
        for (int i = (a > b ? a : b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                nod = i;
                break;
            }
        }

        return nod;
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
}
