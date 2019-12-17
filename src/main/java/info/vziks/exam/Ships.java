package info.vziks.exam;

import java.util.concurrent.Semaphore;

public class Ships {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(4);

        for (int i = 1; i <= 40; i++) {
            (new Ship(sem, i)).start();
        }
    }

    static class Ship extends Thread {
        Semaphore sem;
        int id;

        Ship(Semaphore sem, int id) {
            this.sem = sem;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                synchronized (sem){
                    sem.acquire();
                }
                System.out.println("Ship " + id + " вошел");
                sleep(2000);
                System.out.println("Ship " + id + " вышел");
                sleep(2000);
                sem.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
