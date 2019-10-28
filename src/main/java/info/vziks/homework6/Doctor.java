package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;

class Doctor extends Unit {
    Doctor() throws TaskCommandException {
        super(75, 15);
    }

    public Doctor(int heals, int damage) throws TaskCommandException {
        super(heals, damage);
    }

    @Override
    void attack(Unit target) {
        target.getDamage((this.getRandom().nextBoolean() ? 1 : 2) * this.getDamage());
    }
}
