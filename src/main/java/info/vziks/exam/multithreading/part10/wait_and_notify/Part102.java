package info.vziks.exam.multithreading.part10.wait_and_notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part102 {
    static Scanner scanner = new Scanner(System.in);
    static List<String> stringList = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {

        Print print = new Print();
        Op op = new Op();
        print.start();
        op.start();
    }

    static class Print extends Thread {

        @Override
        public void run() {
            try {
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public void print() throws InterruptedException {
            while (true) {
                synchronized (stringList) {
                    stringList.wait();
                }

                System.out.println(stringList.remove(0));
            }
        }
    }

    static class Op extends Thread {
        @Override
        public void run() {
            try {
                enter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void enter() throws InterruptedException {
            while (true) {
                synchronized (stringList) {
                    System.out.println("Enter data");
                    stringList.add(scanner.nextLine());
                    stringList.notify();
                }
                Thread.sleep(1000);
            }
        }
    }
}
