package info.vziks.homework4.animals;

import info.vziks.exceptions.TaskCommandException;

public class Cat {

    private String name;
    private int age;
    private int weight;
    private int strength;

    public Cat(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws TaskCommandException {
        if (weight <= 0) throw new TaskCommandException();
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws TaskCommandException {
        if (weight <= 0) throw new TaskCommandException();
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) throws TaskCommandException {
        if (strength <= 0) throw new TaskCommandException();
        this.strength = strength;
    }


    public boolean fight(Cat cat) {
        boolean bln = true;
        if (this.rateCat() < cat.rateCat()) {
            bln = false;
        }
        return bln;
    }


    private double rateCat() {
        return weight * strength / age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    сила/возраст*вес
//    age + weight * strength
//    weight * strength / age
}
