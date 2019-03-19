package info.vziks.homework5;

public class Substraction implements CalculatorInterface {
    static char code = 45;
    @Override
    public double execute(double number1, double number2) {
        return number1 - number2;
    }
}
