package info.vziks.exam.multithreading.part4.static_methods;

import java.util.Random;

public class Resource {

    static int staticInt;

    int value;
    static private Random rand = new Random();

    public Resource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public synchronized static void changeStaticInt() {
        int staticInt = Resource.staticInt;
        if (rand.nextBoolean()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        staticInt++;

        Resource.staticInt = staticInt;
    }

    public static void changeStaticBlockInt() {
        synchronized (Resource.class) {
            int staticInt = Resource.staticInt;
            if (rand.nextBoolean()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            staticInt++;

            Resource.staticInt = staticInt;
        }
    }

}
