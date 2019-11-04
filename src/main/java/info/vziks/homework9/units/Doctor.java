package info.vziks.homework9.units;

import java.util.StringJoiner;

public class Doctor extends BattleUnit {
    public Doctor(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit friend) {
        System.out.println("Доктор увеличил очки здоровья " + friend.getName());
    }

    @Override
    public void rest() {
        System.out.println("Доктор отдыхает");
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Doctor.class.getSimpleName() + "[", "]")
                .add("attackScore=" + attackScore)
                .add("name='" + name + "'")
                .add("health=" + health)
                .add("speed=" + speed)
                .toString();
    }
}
