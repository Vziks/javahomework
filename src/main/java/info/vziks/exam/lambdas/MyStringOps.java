package info.vziks.exam.lambdas;

class MyStringOps {
    static String srtReverse(String s) {
        return MyStringOps.manString(s);
    }

    String srtReverseNotStatic(String s) {
        return MyStringOps.manString(s);
    }

    static String manString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
