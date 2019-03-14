package info.vziks.homework3;

import info.vziks.utils.Command;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Task37Command
 *
 * @author Anton Prokhorov
 */
public class Task37Command implements Command {

    private int[] arrTemp = {};

    private Scanner stdIn = new Scanner(System.in).useDelimiter("\n");

    @Override
    public void execute() {

        System.out.println("Enter source string");
        StringBuilder sourceString = new StringBuilder(getStdIn().next());
        System.out.println(sourceString.toString());

        stringToNumberArray(sourceString);

        for (int i = 0; i < arrTemp.length; i++) {
            System.out.println(arrTemp[i]);
        }
    }

    private void stringToNumberArray(StringBuilder sourceString) {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(sourceString);
        int start = 0;
        while (matcher.find(start)) {
            String value = sourceString.toString().substring(matcher.start(), matcher.end());
            setArrTemp(Task32Command.addElement(getArrTemp(), Integer.parseInt(value)));
            start = matcher.end();
        }
    }


    public int[] getArrTemp() {
        return arrTemp;
    }

    public void setArrTemp(int[] arrTemp) {
        this.arrTemp = arrTemp;
    }

    public Scanner getStdIn() {
        return stdIn;
    }
}
