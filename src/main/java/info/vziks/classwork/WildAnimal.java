package info.vziks.classwork;

abstract class WildAnimal extends Animal implements IPredatory {
    private int straight;
    private int trays;

    public int getStraight() {
        return straight;
    }

    public WildAnimal(int speed, int straight, int trays) {
        super(speed);
        this.straight = straight;
        this.trays = trays;
    }

    public void setStraight(int straight) {
        this.straight = straight;
    }

    public int getTrays() {
        return trays;
    }

    public void setTrays(int trays) {
        this.trays = trays;
    }
}
