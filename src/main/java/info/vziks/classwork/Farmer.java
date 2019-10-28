package info.vziks.classwork;

import java.util.Random;

public class Farmer {


    public Farmer(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    int costPerDay;

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public boolean tryToKickAway() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

}
