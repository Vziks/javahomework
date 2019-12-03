package info.vziks.exam.less16;

public class LambdasAndVars {
    static int a = 12;
    static int b = 15;


    public static void main(String[] args) {
        int i = 10;
        int y = 20;

        String sss = "asdasd";
        Integer qq = 10;
        Message message = new Message("1111");
//        SomeInterface someInterface = (i,y)->{ lock vars
//            return i + y;
//        };
        SomeInterface someInterface = () -> {
//            sss = "11"; lock link
//            qq = 20; lock link
//            Message message = new Message("1111"); lock link
            message.setText("1111");
            return i + y;
        };
        System.out.println(someInterface.doSom());
    }

}

@FunctionalInterface
interface SomeInterface {
    int doSom();
}

class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }
}