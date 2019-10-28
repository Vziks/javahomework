package info.vziks.classwork;

public class Rabbit extends HomeAnimal implements IEdible {
    public Rabbit(int speed, String name, int weight, int hp) {
        super(speed, name, weight, hp, 0);
    }
}
