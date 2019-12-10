package info.vziks.exam.multithreading;

public class Robot {
    volatile boolean currentLeg = true;
    Leg right = new Leg("Right", true);
    Leg left = new Leg("Left", false);


    public void start() {
        Thread rightT = new Thread(right);
        Thread leftT = new Thread(left);
        rightT.setPriority(Thread.MAX_PRIORITY);
        leftT.setPriority(Thread.MIN_PRIORITY);
        rightT.start();
        leftT.start();
    }

    public static void main(String[] args) {
        new Robot().start();
    }

    class Leg implements Runnable {
        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg = leg;
        }

        @Override
        public void run() {
            while (true) {
                if (leg == currentLeg) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    step();
                    currentLeg = !leg;
//                    Thread.yield();
                }
            }
        }

        public void step() {
            System.out.println(this.name);
        }
    }
}
