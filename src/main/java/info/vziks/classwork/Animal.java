package info.vziks.classwork;

abstract class Animal {

    public Animal(int speed) {
        this.speed = speed;
    }

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
