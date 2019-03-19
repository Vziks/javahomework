package info.vziks.homework5;

public class Division implements CalculatorInterface {
    static char code = 47;

    @Override
    public double execute(double number1, double number2) {
        return number1 / number2;
    }
}
