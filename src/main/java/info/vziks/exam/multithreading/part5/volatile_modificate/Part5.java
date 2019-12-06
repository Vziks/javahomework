package info.vziks.exam.multithreading.part5.volatile_modificate;

import java.util.Arrays;

public class Part5 {

    private static volatile int value = 0;

    public static void main(String[] args) {
        MyThreadRead myThreadRead = new MyThreadRead();
        MyThreadWrite myThreadWrite = new MyThreadWrite();
        myThreadRead.start();
        myThreadWrite.start();
    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while (value < 5) {
                ++value;
                System.out.println("MyThreadRead value " + (value));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = value;
            while (localVar < 5) {
                if (localVar != value) {
                    System.out.println("MyThreadWrite value " + value);
                    localVar = value;
                }
            }

        }
    }
}

