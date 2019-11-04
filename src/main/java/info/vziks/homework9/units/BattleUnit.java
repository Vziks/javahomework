package info.vziks.homework9.units;

// BattleUnit bu = new BattleUnit("юнит", 6);

import com.github.javafaker.Faker;

abstract public class BattleUnit extends Unit implements AttackAble {

    private static Faker faker = new Faker();

    public static BattleUnit getUnitByName(String name) {
        BattleUnit battleUnit = null;
        if (name.equals("warrior")) {
            battleUnit = new Warrior(faker.name().name(), faker.number().numberBetween(10, 15),  faker.number().numberBetween(10, 15), faker.number().numberBetween(10, 15));
        } else if (name.equals("knight")) {
            battleUnit = new Knight(faker.name().name(), faker.number().numberBetween(10, 15),  faker.number().numberBetween(10, 15), faker.number().numberBetween(10, 15));
        } else if (name.equals("doctor")) {
            battleUnit = new Doctor(faker.name().name(), faker.number().numberBetween(10, 15),  faker.number().numberBetween(10, 15), faker.number().numberBetween(10, 15));
        }
        return battleUnit;
    }

    protected int attackScore;

    public BattleUnit(String name, int speed, int health, int attackScore) {
        super(name, speed);
        this.health = health;
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }


    @Override
    public String toString() {
        return "BattleUnit{" +
                "attackScore=" + attackScore +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void escapeBattleField() {
        System.out.println("Юнит " + this.name + " сбежал с поля боя");
    }
}
