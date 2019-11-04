package info.vziks.homework9.units;

import java.util.StringJoiner;

public class Warrior extends BattleUnit {
    public Warrior(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }


    @Override
    public void attack(Unit enemy) {
        System.out.println("Воин атаковал " + enemy.getName());
    }

    @Override
    public void rest() {
        System.out.println("Воин отдыхает");
    }

    @Override
    public void run(){
        super.run(); // вызов метода родителя
        System.out.println("Расширение функционала");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Warrior.class.getSimpleName() + "[", "]")
                .add("attackScore=" + attackScore)
                .add("name='" + name + "'")
                .add("health=" + health)
                .add("speed=" + speed)
                .toString();
    }
}
