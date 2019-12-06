package info.vziks.exam.multithreading.part1;


public class CheckMyRunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {
            System.out.println("Thread name - " + Thread.currentThread().getName() + " i="  + i);
        }
    }
}
