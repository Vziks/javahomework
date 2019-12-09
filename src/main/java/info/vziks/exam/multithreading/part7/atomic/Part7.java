package info.vziks.exam.multithreading.part7.atomic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Part7 {

    static int i;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 1_000_0; j++) {

            MyThread1 myThread1 = new MyThread1();
            MyThread2 myThread2 = new MyThread2();
            myThread1.start();
            myThread2.start();
        }
        Thread.sleep(2000);

        System.out.println("i = " + i);
        System.out.println("AtomicInteger = " + atomicInteger);

    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            Thread.yield();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;

        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            Thread.yield();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicInteger.incrementAndGet();

        }
    }
}
