package info.vziks.exam.lambdas;

public class MainMyStringOpsOne {

    static String stringOps(StringFunc strFunc, String s) {
        return strFunc.func(s);
    }

    public static void main(String[] args) {
        String inString = "Java is the best";
        String outString;
        outString = MainMyStringOpsOne.stringOps(MyStringOps::srtReverse, inString);

        System.out.println(inString);
        System.out.println(outString);
    }
}