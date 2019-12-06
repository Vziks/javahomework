package info.vziks.exam.multithreading.part3.synchronize;

public class Part3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Resource resource = new Resource(5);
            SynchronizeThread synchronizeThread1 = new SynchronizeThread();
            SynchronizeThread synchronizeThread2 = new SynchronizeThread();
            synchronizeThread1.setResource(resource);
            synchronizeThread2.setResource(resource);
            synchronizeThread1.start();
            synchronizeThread2.start();

            try {
                synchronizeThread1.join();
                synchronizeThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//             Join yе гарантирует что поток был завершен, т.е.
//             в результат попадет не 7 а 6 и меньше
//             synchronized модификатор информирует
//             поток что они должны быть завершены и только п
//             после это получим правильны результат
//             Output without synchronized on method
//             public void increaseValue()
//            > Task :Part3.main()
//            6
//            7
//            7
//            6
//            7
//            7
//            7
//            7
//            7
//            7
//             Output with synchronized on method
//             public synchronized void increaseValue()
//            > Task :Part3.main()
//            7
//            7
//            7
//            7
//            7
//            7
//            7
//            7
//            7
//            7
            System.out.println(resource.getValue());
        }


    }
}
