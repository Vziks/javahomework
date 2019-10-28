package info.vziks.classwork;

interface IPredatory {
    boolean checkSpeed(Animal animal);

    boolean checkEaten();

    void hurt(HomeAnimal animal);
}
