package info.vziks.homework13.Calculator;

import info.vziks.homework13.Exception.DivisionByZero;
import info.vziks.homework13.Exception.InvalidFormat;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppCalculator {

    private Scanner stdIn = new Scanner(System.in).useDelimiter("\n");

    private Map<String, CalculatorInterface> hashMap = new HashMap<>();

    private String regExp = "(\\d+)([\\-\\+\\*\\/])(\\d+)";
    private String input = "";

    private Pattern patternOperation = Pattern.compile(regExp);
    private Matcher matcher;

    public AppCalculator() {
        for (Operator op : Operator.values()) {
            hashMap.put(op.getOperand(), op.getCalculatorInterface());
        }
    }

    public void run() throws InvalidFormat, DivisionByZero {

        do {
            System.out.println("Please enter operation");
            input = stdIn.next();
            matcher = patternOperation.matcher(input);
            if (matcher.find()) {
                if (matcher.matches()) {
                    System.out.println(hashMap.get(
                            matcher.group(2)).calculation(
                            Double.parseDouble(matcher.group(1)),
                            Double.parseDouble(matcher.group(3))
                    ));
                }
            } else if ("exit".equals(input)) {
                //TODO fix this =\
            } else {
                throw new InvalidFormat();
            }
        } while (!"exit".equals(input));
    }
}
