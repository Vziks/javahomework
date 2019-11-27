package info.vziks.exam.lambdas;

public class MainMyStringOpsTwo {
    static String stringOps(StringFunc strFunc, String s) {
        return strFunc.func(s);
    }

    public static void main(String[] args) {

        String inString = "Java is the best";
        String outString;

        MyStringOps myStringOps = new MyStringOps();

        outString = stringOps(myStringOps::srtReverseNotStatic, inString);
        System.out.println(inString);
        System.out.println(outString);
    }

}
