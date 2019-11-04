package info.vziks.homework9.units;


import java.util.StringJoiner;

public class Knight extends BattleUnit {
    public Knight(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit enemy) {
        System.out.println("Рыцарь атаковал " + enemy.getName());
    }

    @Override
    public void rest() {
        System.out.println("Рыцарь отдыхает");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Knight.class.getSimpleName() + "[", "]")
                .add("attackScore=" + attackScore)
                .add("name='" + name + "'")
                .add("health=" + health)
                .add("speed=" + speed)
                .toString();
    }
}
