package info.vziks.homework5;

public class Multiplication implements CalculatorInterface {
    static char code = 42;

    @Override
    public double execute(double number1, double number2) {
        return number1 * number2;
    }
}
