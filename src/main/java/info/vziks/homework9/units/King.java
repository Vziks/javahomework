package info.vziks.homework9.units;

import java.util.StringJoiner;

public class King extends Unit {

    private static King instanceKing;

    private King(String name, int speed, int health){
        super(name, speed);
        this.health = health;
    }

    public static King getInstance(int speed, int health){

        if(instanceKing == null){
            instanceKing = new King("Король",speed,health);
        }
        return instanceKing;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", King.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("health=" + health)
                .add("speed=" + speed)
                .toString();
    }

    @Override
    public void rest() {
        System.out.println("Король отдыхает");
    }



}
