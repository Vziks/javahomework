package info.vziks.exam.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface Operation {
    double execute(double a, double b);

    default double calculationMethod(double v1, double v2) {
        return v1 + v2;
    }
}

public class Calculator {
    public double calculate(double a, double b, Operation operation) {
        return operation.execute(a, b);
    }

    public Integer num = 10;

    public static void main(String[] args) {
        Operation plus = Double::sum;
        Operation minus = (a, b) -> (a - b);
        Operation div = (a, b) -> {
            if (b == 0) throw new IllegalArgumentException();
            return a / b;
        };

        Calculator calculator = new Calculator();


        calculator.num = 20;
        Predicate<Integer> pos1 = (num1) -> num1 > 0;
        Predicate<Integer> pos2 = (num2) -> num2 > 0;
        Predicate<Integer> pos3 = (num2) -> calculator.num > 0;
        Predicate<Integer> isEven = (num3) -> num3 % 2 == 0;
        calculator.num++;

        pos2.test(10);

        System.out.println(pos1.and(isEven).test(45));
        System.out.println(pos2.or(isEven).test(22));


        Function<Integer, Double> tenProc = (intVal) -> intVal * 0.1;
        Function<Integer, Integer> plusProc = (intVal) -> intVal + (int) (intVal * 0.05);

        System.out.println(plusProc.andThen(plusProc).andThen(plusProc).apply(100));


        plusProc.apply(100);

        Function<Integer, String> par = (intVal) -> intVal.toString() + "$";


        System.out.println(par.apply(4));

        BinaryOperator<Double> binaryOperator = (x, y) -> x / y;
        System.out.println(binaryOperator.apply(2d, 1d));
    }

    public static Function<Integer, Integer> getFunction(
            Predicate<Integer> predicate,
            Function<Integer, Integer> function1,
            Function<Integer, Integer> function2) {
        return num -> predicate.test(num) ? function1.apply(num) : function2.apply(num);
    }
}



