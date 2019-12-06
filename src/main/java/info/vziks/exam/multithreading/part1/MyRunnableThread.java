package info.vziks.exam.multithreading.part1;

public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Self:Name " + Thread.currentThread().getName());
        someMethod();
    }

    private void someMethod() {
        throw new RuntimeException();
    }
}
