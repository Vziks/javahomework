package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;

class Warrior extends Unit {

    Warrior() throws TaskCommandException {
        super(100, 14);
    }

    public Warrior(int heals, int damage) throws TaskCommandException {
        super(heals, damage);
    }

    @Override
    void attack(Unit target) {
        target.getDamage((this.getRandom().nextBoolean() ? 1 : 2) * this.getDamage());
    }
}
