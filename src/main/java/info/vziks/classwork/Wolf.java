package info.vziks.classwork;

import java.util.Random;

public class Wolf extends WildAnimal {

    public Wolf(int speed, int straight, int trays) {
        super(speed, straight, trays);
    }

    @Override
    public boolean checkSpeed(Animal animal) {
        return this.getSpeed() < animal.getSpeed();
    }

    @Override
    public boolean checkEaten() {
        return (new Random()).nextBoolean();
    }

    @Override
    public void hurt(HomeAnimal animal) {
        animal.setHp(animal.getHp() - this.getStraight());

    }
}
