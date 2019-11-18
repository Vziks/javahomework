package info.vziks.homework13.Calculator;

import info.vziks.homework13.Exception.DivisionByZero;

public interface CalculatorInterface {
    double calculation(double v1, double v2) throws DivisionByZero;
}
