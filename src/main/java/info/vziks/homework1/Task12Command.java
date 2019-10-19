package info.vziks.homework1;

import info.vziks.utils.Command;

/**
 * Class Task12Command
 *
 * @author Anton Prokhorov
 */
public class Task12Command implements Command {

    private Object obj;
    private int to;
    private int from;
    private StringBuilder sb = new StringBuilder();

    private char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public Task12Command() {
        this.to = 10;
        this.from = 10;
    }

    public Task12Command(Object obj, int to, int from) {
        this.obj = obj;
        this.to = to;
        this.from = from;
    }

    public Task12Command(Object obj, int to) {
        this.obj = obj;
        this.to = to;
    }

    @Override
    public void execute() {

        setObj(20000);
        setTo(8);


        System.out.println("Result " + convert());
    }


    /**
     * @return String
     */
    public String convert() {

        String str = String.valueOf(obj);

        if (str != null && str.equals(obj)) {

            char[] stringToCharArray = str.toCharArray();

            int s = 0;
            for (int i = 0; i < stringToCharArray.length; i++) {
                s = (s + getArrayIndex(charArray, stringToCharArray[i]) * (int) Math.pow(from, stringToCharArray.length - i - 1));
            }

            sb.append(s);

        } else {

            int input = (int) obj;
            while (input > 0) {
                sb.append(charArray[input % to]);
                input = input / to;
            }
            sb.reverse();
        }

        return sb.toString();
    }

    private int getArrayIndex(char[] arr, int value) {

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                k = i;
                break;
            }
        }
        return k;
    }


    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
}
