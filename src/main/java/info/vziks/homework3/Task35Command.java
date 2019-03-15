package info.vziks.homework3;

import info.vziks.utils.Command;

import java.util.Scanner;

/**
 * Class Task35Command
 *
 * @author Anton Prokhorov
 */
public class Task35Command implements Command {
    private Scanner stdIn = new Scanner(System.in).useDelimiter("\n");

    @Override
    public void execute() {

        System.out.println("Enter source string");
        StringBuilder sourceString = new StringBuilder(stdIn.next());
        System.out.println(sourceString.toString());

        System.out.println("Type a substring to replace");
        String replaceToString = getStdIn().next();

        System.out.println("Enter a string to insert");
        String insertToString = getStdIn().next();

        int start = sourceString.indexOf(replaceToString);
        while (start > -1) {
            sourceString.delete(start, start + replaceToString.length());
            sourceString.insert(start, insertToString);
            start = sourceString.indexOf(replaceToString);
        }

        System.out.println(sourceString);

    }

    public Scanner getStdIn() {
        return stdIn;
    }


}
