package info.vziks.exam.multithreading.part9.deadlock;

public class Part9 {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            RecourseA recourseA = new RecourseA();
            RecourseB recourseB = new RecourseB();
            recourseA.recourseB = recourseB;
            recourseB.recourseA = recourseA;
            recourseA.start();
            recourseB.start();
        }
    }

    static class RecourseA extends Thread {

        @Override
        public void run() {
            Thread.yield();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getI();
        }

        RecourseB recourseB;

        public synchronized int getI() {
            return recourseB.returnI();
        }

        public synchronized int returnI() {
            return 1;
        }
    }

    static class RecourseB extends Thread {

        @Override
        public void run() {
            Thread.yield();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getI();
        }

        RecourseA recourseA;

        public synchronized int getI() {
            return recourseA.returnI();
        }

        public synchronized int returnI() {
            return 1;
        }
    }
}


