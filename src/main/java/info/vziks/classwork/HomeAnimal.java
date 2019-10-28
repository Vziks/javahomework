package info.vziks.classwork;

abstract class HomeAnimal extends Animal {
    private String name;
    private int weight;
    private int hp;
    private int recourse;

    public HomeAnimal(int speed, String name, int weight, int hp, int recourse) {
        super(speed);
        this.name = name;
        this.weight = weight;
        this.hp = hp;
        this.recourse = recourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getRecourse() {
        return recourse;
    }

    public void setRecourse(int recourse) {
        this.recourse = recourse;
    }
}
