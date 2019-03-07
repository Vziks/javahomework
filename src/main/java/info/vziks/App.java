package info.vziks;

/**
 * Hello world!
 */
public class App {

    private String str;

    App(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public static void main(String[] args) {
        System.out.println(new App("Hello world").getStr());
    }
}
