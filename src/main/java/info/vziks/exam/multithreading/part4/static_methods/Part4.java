package info.vziks.exam.multithreading.part4.static_methods;

public class Part4 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Resource.staticInt = 20;
            SynchronizeThread synchronizeThread1 = new SynchronizeThread();
            SynchronizeThread synchronizeThread2 = new SynchronizeThread();
            synchronizeThread1.start();
            synchronizeThread2.start();

            try {
                synchronizeThread1.join();
                synchronizeThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Resource.staticInt);

        }
    }
}
