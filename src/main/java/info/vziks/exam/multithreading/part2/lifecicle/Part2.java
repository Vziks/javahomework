package info.vziks.exam.multithreading.part2.lifecicle;

public class Part2 {
    public static void main(String[] args) {

        Thread checkMyRunnable1 = new Thread(new CheckMyRunnableThread("checkMyRunnable1"));
        Thread checkMyRunnable2 = new Thread(new CheckMyRunnableThread("checkMyRunnable2"));
        Thread checkMyRunnable3 = new Thread(new CheckMyRunnableThread("checkMyRunnable3"));
        checkMyRunnable1.setPriority(Thread.MIN_PRIORITY);
        checkMyRunnable2.setPriority(Thread.NORM_PRIORITY);
        checkMyRunnable3.setPriority(Thread.MAX_PRIORITY);
        checkMyRunnable1.start();
        checkMyRunnable2.start();
        checkMyRunnable3.start();

        try {
            checkMyRunnable1.join();
            checkMyRunnable2.join();
//            Дождаться выполения потока с именем checkMyRunnable2 и
//            только потом отдать общему стеку, т.е. блок main, т.к. это отдельный
//            поток выполниться только после checkMyRunnable2
//            Output:
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=0
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=0
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=0
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=1
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=1
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=2
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=1
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=3
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=2
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=3
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=4
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=4
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=5
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=2
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=3
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=6
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=5
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=6
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=7
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=7
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=4
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=8
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=8
//            Thread name - checkMyRunnable1 Sysname Thread-0 i=9
//            Thread name - checkMyRunnable2 Sysname Thread-1 i=9
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=5
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=6
//            main
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=7
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=8
//            Thread name - checkMyRunnable3 Sysname Thread-2 i=9
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());
//        Output: not granted sequence
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=0
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=0
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=0
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=1
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=1
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=1
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=2
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=3
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=2
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=3
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=4
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=2
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=4
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=3
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=5
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=5
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=4
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=6
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=6
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=5
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=6
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=7
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=8
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=7
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=7
//        Thread name - checkMyRunnable3 Sysname Thread-2 i=9
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=8
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=8
//        Thread name - checkMyRunnable2 Sysname Thread-1 i=9
//        Thread name - checkMyRunnable1 Sysname Thread-0 i=9


//        Thread checkMyRunnable4 = new Thread(new CheckMyRunnableThread());

    }
}
