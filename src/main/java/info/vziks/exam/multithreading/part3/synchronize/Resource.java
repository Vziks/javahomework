package info.vziks.exam.multithreading.part3.synchronize;

import java.util.Random;

public class Resource {
    int value;
    private Random rand = new Random();

    public Resource(int value) {
        this.value = value;
    }

    public synchronized void increaseValue() {
        if (rand.nextBoolean()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value++;
    }

//    public void increaseValue() {
//        synchronized (this) {
//            if (rand.nextBoolean()) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        this.value++;
//    }


    public int getValue() {
        return value;
    }
}
