package info.vziks.exam.multithreading.part6.exception_handler;

public class Solution {

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {//тут создается констрктор в который мы передаем переменную типа UncaughtExceptionHandler
            setUncaughtExceptionHandler(handler);//то есть реализацию интерфейса; не могу понять  setUncaughtExceptionHandler() что делает этот метод
            start();
        }
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");
            }
        }
    }
    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {//тут, я лишь могу предположить что это нечто вроде метода toString
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}