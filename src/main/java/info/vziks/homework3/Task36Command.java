package info.vziks.homework3;

import info.vziks.utils.Command;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class Task36Command
 *
 * @author Anton Prokhorov
 */
public class Task36Command implements Command {

    private Scanner stdIn = new Scanner(System.in).useDelimiter("\n");

    @Override
    public void execute() {
        System.out.println("Enter source string");
        StringBuilder sourceString = new StringBuilder(getStdIn().next());
        System.out.println(sourceString.toString());

        trimAndRemoteDuplicate(sourceString);
    }

    private void trimAndRemoteDuplicate(StringBuilder sourceString) {
        for (int i = 0; i < sourceString.length(); i++) {
            while (sourceString.lastIndexOf(Character.toString(sourceString.charAt(i))) != i) {
                sourceString.deleteCharAt(sourceString.lastIndexOf(Character.toString(sourceString.charAt(i))));
            }
        }
        System.out.println(Pattern.compile(" ").matcher(sourceString).replaceAll(""));
    }

    public Scanner getStdIn() {
        return stdIn;
    }
}
