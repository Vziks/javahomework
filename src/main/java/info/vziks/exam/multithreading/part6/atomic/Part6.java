package info.vziks.exam.multithreading.part6.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Part6 {
    static int i;
    static int y;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        for (int f = 0; f < 10; f++) {


            for (int j = 0; j < 10_000; j++) {
                Thread thread = new Thread(new MyThreadRunnable());
                thread.start();
            }

            for (int j = 0; j < 10_000; j++) {
                new MyThreadThread().start();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            System.out.println(y);
            System.out.println(atomicInteger.get());
        }
    }


    static class MyThreadRunnable implements Runnable {

        @Override
        public void run() {
            atomicInteger.incrementAndGet();
            Thread.yield();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = i + 1;
            i = a;
        }
    }

    static class MyThreadThread extends Thread {

        @Override
        public void run() {
            atomicInteger.incrementAndGet();
            Thread.yield();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = y + 1;
            y = a;
        }
    }
}
