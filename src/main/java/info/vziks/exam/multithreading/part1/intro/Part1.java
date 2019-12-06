package info.vziks.exam.multithreading.part1.intro;

import java.util.Map;

public class Part1 {

    public static void main(String[] args) {

        MyExtendsThread myExtendsThread1 = new MyExtendsThread();
        myExtendsThread1.start();

        MyExtendsThread myExtendsThread2 = new MyExtendsThread();
        myExtendsThread2.start();
        // Name: main
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName());
        // Name: Thread-0
        System.out.println("classMyThread1.getName() " + myExtendsThread1.getName());
        // Name: Thread-1
        System.out.println("classMyThread2.getName() " + myExtendsThread2.getName());

        MyRunnableThread myRunnableThread1 = new MyRunnableThread();
        MyRunnableThread myRunnableThread2 = new MyRunnableThread();

        Thread myRunnable1 = new Thread(myRunnableThread1);
        Thread myRunnable2 = new Thread(myRunnableThread2);

        myRunnable1.start();
        myRunnable2.start();

        System.out.println(Thread.activeCount());
        System.out.println("Thread.getDefaultUncaughtExceptionHandler() " + Thread.getDefaultUncaughtExceptionHandler());

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

        for (Map.Entry<Thread, StackTraceElement[]> entity :
                map.entrySet()) {
            System.out.println("Thread\n");
            System.out.println(entity.getKey());
            System.out.println("stackTraceElements\n");
            for (StackTraceElement stackTraceElement :
                    entity.getValue()) {
                System.out.println(stackTraceElement);
            }
        }

        CheckMyRunnableThread checkMyRunnableThread1 = new CheckMyRunnableThread();
        CheckMyRunnableThread checkMyRunnableThread2 = new CheckMyRunnableThread();
        CheckMyRunnableThread checkMyRunnableThread3 = new CheckMyRunnableThread();
        Thread checkMyRunnable1 = new Thread(checkMyRunnableThread1);
        Thread checkMyRunnable2 = new Thread(checkMyRunnableThread2);
        Thread checkMyRunnable3 = new Thread(checkMyRunnableThread3);
        checkMyRunnable1.start();
        checkMyRunnable2.start();
        checkMyRunnable3.start();
    }
}


