package info.vziks.homework5;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class HomeWork5Main {

    private static Scanner stdIn = new Scanner(System.in).useDelimiter("\n");
    private static CalculatorFactory factory = new CalculatorFactory();
    private static int num1, num2;
    private static char[] chars = {Division.code, Multiplication.code, Addition.code, Substraction.code};
    private static char symbol;

    public static void init() {
        factory.add(new Addition(), Character.toString(Addition.code));
        factory.add(new Substraction(), Character.toString(Substraction.code));
        factory.add(new Division(), Character.toString(Division.code));
        factory.add(new Multiplication(), Character.toString(Multiplication.code));
    }


    public static void main(String[] args) {

        init();

        do {
            num1 = input();
        } while (num1 <= 0);

        do {
            System.out.println("Please enter a operand!" + chars);
            while (!stdIn.hasNextLine()) {
                System.out.println("That not a operand!");
                stdIn.next();
            }
            symbol = stdIn.next().charAt(0);
        } while (!ArrayUtils.contains(chars, symbol));

        do {
            num2 = input();
        } while (num2 <= 0);

        getResult(symbol, num1, num2);
    }

    public static void getResult(char symbol, int num1, int num2) {
        System.out.println("Result :" + factory.getInstance(String.valueOf(symbol)).execute(num1, num2));
    }

    private static int input() {
        System.out.println("Please enter a positive number!");
        while (!stdIn.hasNextInt()) {
            System.out.println("That not a number!");
            stdIn.next();
        }
        return stdIn.nextInt();
    }
}
