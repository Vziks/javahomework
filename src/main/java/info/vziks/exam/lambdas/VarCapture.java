package info.vziks.exam.lambdas;


interface Myfunc {
    int func(int n);
}

public class VarCapture {
    public static void main(String[] args) {
        int num = 10;
//        num = 9; //Error
        Myfunc lambda= (n) -> {
            int v =  num + n;
//             num++; //Error
            return v;
        };

        System.out.println(lambda.func(10));
//        num = 9;//Error
    }
}
