package info.vziks.exam.multithreading.part6.exception_handler;

public class Part6 {

    public static Thread.UncaughtExceptionHandler handler = new Solution.OurUncaughtExceptionHandler();//создается объект класса OurUncaughtExceptionHandler

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);//создался объект написанного класса  TestedThread, и в него передали объект handler
        Thread threadA = new Thread(commonThread, "Нить 1");//вот эту петрушку я не понимаю, создаются две нити в которые влажуем еще одну нить
        Thread threadB = new Thread(commonThread, "Нить 2");//зачем все так запутывать?
        threadA.start();//запустились нити
        threadB.start();
        threadA.interrupt();//и их сразу же остановили, при том что commonThread еще не отработал
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {//тут создается конструктор в который мы передаем переменную типа UncaughtExceptionHandler
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
}
