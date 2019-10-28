package info.vziks.classwork;

class Chicken extends HomeAnimal implements IEdible, IResourceSource {
    public Chicken(int speed, String name, int weight, int hp, int recourse) {
        super(speed, name, weight, hp, recourse);
    }
}
