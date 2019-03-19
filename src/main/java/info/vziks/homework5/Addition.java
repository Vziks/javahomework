package info.vziks.homework5;

public class Addition implements CalculatorInterface {
    static char code = 43;

    @Override
    public double execute(double number1, double number2) {
        return number1 + number2;
    }
}
