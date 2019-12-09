package info.vziks.exam.multithreading.part2.lifecicle;


import java.util.Random;

public class CheckMyRunnableThread implements Runnable {
    private String nameThread;

    public CheckMyRunnableThread(String nameThread) {
        this.nameThread = nameThread;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name - " + this.nameThread + " Sysname " + Thread.currentThread().getName() + " i=" + i);
            if (rand.nextBoolean()) {
                /*
                 not granted
                 Статический метод Thread.yield() заставляет процессор переключиться
                 а обработку других потоков системы. Метод может быть полезным, например,
                 когда поток ожидает наступления какого-либо события и необходимо чтобы
                 проверка его наступления происходила как можно чаще. В этом случае можно
                 поместить проверку события и метод Thread.yield() в цикл:
                 */
                Thread.yield();
            }
            if (rand.nextBoolean()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                /* InterruptedException — это checked exception генерируемый многими методами
                 стандартной библиотеки, которые блокируют поток исполнения.

                 Зачем нужен InterruptedException?

                 InterruptedException позволяет прервать поток уже выполняющий блокирующий
                 вызов. В случае, если метод уже выполняется, то существует только один способ
                 прервать его выполнение без возврата какого-либо значения и не нарушая при
                 этом его контракт, — сгенерировать исключительную ситуацию. В этом случае
                 возвращаемое значение метода просто неопределено.
                 */
                    e.printStackTrace();
                }
            }
        }


    }
}
