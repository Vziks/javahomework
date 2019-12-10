package info.vziks.exam.multithreading.part10.wait_and_notify;

import java.util.Scanner;

public class Part101 {

    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor();
        Thread myThread1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread myThread2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();
    }

    static class Processor {
        Scanner scanner = new Scanner(System.in);
        private String input = "";

        public void produce() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    System.out.println("Running produce ...");
                    System.out.println("input var " + input);
                    wait();
                    System.out.println("input string" + input);
                    System.out.println("after wait...");
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                Thread.sleep(2000);
                synchronized (this) {
                    System.out.println("Waiting for return key");
                    input = scanner.nextLine();
                    System.out.println("Press key");
                    notify();
                    System.out.println("notify synchronized block on this class");
                }
            }
        }
    }
}
