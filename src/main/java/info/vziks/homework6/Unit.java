package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;

import java.util.Random;

abstract class Unit {
    private Random random = new Random();
    private int heals;
    private int damage;
    private boolean isDead;

    Unit(int heals, int damage) throws TaskCommandException {
        setHeals(heals);
        setDamage(damage);
    }

    abstract void attack(Unit target);

    public void getDamage(int damage) {
        this.heals = this.heals - damage;
        if (this.heals <= 0) setDead(true);
    };

    public int getHeals() {
        return heals;
    }

    public void setHeals(int heals) throws TaskCommandException {
        if (heals <= 0) {
            throw new TaskCommandException();
        }

        this.heals = heals;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) throws TaskCommandException {
        if (heals <= 0) {
            throw new TaskCommandException();
        }
        this.damage = damage;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "heals=" + heals +
                ", damage=" + damage +
                ", isDead=" + isDead +
                '}';
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Random getRandom() {
        return random;
    }
}
