package info.vziks.homework1;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Class Task5Command
 *
 * @author Anton Prokhorov
 */
public class Task5Command implements Command {

    private Random rand = new Random(47289482);
//        private Random rand = new Random(4);
//    private Random rand = new Random(47);

    private final int min = -75; // Минимальное число для диапазона
    private final int max = 75; // Максимальное число для диапазона

    private double a = rnd();
    private double b = rnd();
    private double c = rnd();

    @Override
    public void execute() {

        double discriminant = getB() * getB() - 4 * getA() * getC();

        if (discriminant > 0) {
            double x1, x2;
            x1 = (-getB() - Math.sqrt(discriminant)) / (2 * getA());
            x2 = (-getB() + Math.sqrt(discriminant)) / (2 * getA());
            System.out.println("The roots of an equation.: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0.0) {
            double x;
            x = -getB() / (2 * getA());
            System.out.println("Equation has a one root: x = " + x);
        } else {
            System.out.println("The equation has no real roots!");
        }
    }

    /**
     * @return double
     */
    public double rnd() {

        double fraction = (new BigDecimal(rand.nextDouble())).setScale(2, BigDecimal.ROUND_FLOOR).doubleValue();

        return (getMin() + getRand().nextInt(getMax() - getMin())) + fraction;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
