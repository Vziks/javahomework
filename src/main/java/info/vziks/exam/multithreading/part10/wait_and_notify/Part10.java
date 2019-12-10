package info.vziks.exam.multithreading.part10.wait_and_notify;

public class Part10 {
    public static void main(String[] args) throws InterruptedException {

        Example example = new Example();
        example.start();

        synchronized (example) {
            System.out.println("go to wait ");
            example.wait();
        }
        System.out.println("result");

        System.out.println(example.total);
    }

    static class Example extends Thread {
        int total;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 15; i++) {
                    total = total + i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                notify();
            }
        }
    }
}
