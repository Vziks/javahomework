package info.vziks.exam;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Resto {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 15; i++) {
            executorService.submit(new Visitor(i));
        }
        executorService.shutdown();
    }

    static class Visitor implements Runnable {
        int i;

        public Visitor(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("Visitor" + i);

        }
    }
}
