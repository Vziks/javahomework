package info.vziks.homework13.Calculator;

import info.vziks.homework13.Exception.DivisionByZero;

public enum Operator {
    Addition("+", Double::sum),
    Subtraction("-", (x, y) -> x - y),
    Division("/", (x, y) -> {
        if (y == 0) throw new DivisionByZero();
        return x / y;
    }),
    Multiplication("*", (x, y) -> x * y);


    private String operand;
    private CalculatorInterface calculatorInterface;


    Operator(String operand, CalculatorInterface calculatorInterface) {
        this.operand = operand;
        this.calculatorInterface = calculatorInterface;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Operator{");
        sb.append("operand='").append(operand).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getOperand() {
        return operand;
    }

    public CalculatorInterface getCalculatorInterface() {
        return calculatorInterface;
    }
}
