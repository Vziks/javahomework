package info.vziks.homework13.Calculator;

import info.vziks.homework13.Exception.DivisionByZero;

@FunctionalInterface
public interface CalculatorInterface {
    double calculation(double v1, double v2) throws DivisionByZero;

    default double calculation1(double v1, double v2) {
        return v1 + v2;
    }
}
