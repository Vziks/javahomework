package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;

class Knight extends Unit {
    Knight() throws TaskCommandException {
        super(200, 10);
    }


    public Knight(int heals, int damage) throws TaskCommandException {
        super(heals, damage);
    }

    @Override
    void attack(Unit target) {

        target.getDamage((this.getRandom().nextBoolean() ? 1 : 2) * this.getDamage());
    }
}
