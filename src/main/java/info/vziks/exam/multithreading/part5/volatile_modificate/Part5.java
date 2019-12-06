package info.vziks.exam.multithreading.part5.volatile_modificate;


public class Part5 {

    private static volatile int value = 0;
    private static volatile int i = 0;

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
                System.out.println("MyThreadWrite value " + (value));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 100; j++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("MyThreadWrite i" + j);
                i = j;
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = value;
            while (localVar < 5) {
                if (localVar != value) {
                    System.out.println("MyThreadRead value " + value);
                    localVar = value;
                }
            }

            for (int j = 0; j <  100; j++) {
                System.out.println("MyThreadRead i" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

