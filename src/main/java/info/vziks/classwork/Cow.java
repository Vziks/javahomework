package info.vziks.classwork;

public class Cow extends HomeAnimal implements IEdible, IResourceSource {
    public Cow(int speed, String name, int weight, int hp, int recourse) {
        super(speed, name, weight, hp, recourse);
    }
}
