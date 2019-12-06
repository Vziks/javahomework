package info.vziks.exam.multithreading.part1.intro;

public class MyExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("Self:Name " + this.getName());
        someMethod();
    }
    private void someMethod(){
        throw new RuntimeException();
    }
}
