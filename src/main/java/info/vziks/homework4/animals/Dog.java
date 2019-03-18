package info.vziks.homework4.animals;

import info.vziks.exceptions.TaskCommandException;

public class Dog {

    private String name = "Rex";
    private int weight = 40;
    private int age = 5;
    private String color;
    private String address;


    public Dog(String name) {
        setName(name);
    }

    public Dog(String name, int weight) throws TaskCommandException {
        setName(name);
        setWeight(weight);
    }

    public Dog(String name, int weight, int age) throws TaskCommandException {
        setName(name);
        setWeight(weight);
        setAge(age);
    }

    public Dog(String name, int weight, int age, String color) throws TaskCommandException {
        setName(name);
        setWeight(weight);
        setAge(age);
        setColor(color);
    }

    public Dog(String name, int weight, int age, String color, String address) throws TaskCommandException {
        setName(name);
        setWeight(weight);
        setAge(age);
        setColor(color);
        setAddress(address);
    }

    public Dog() {
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

    public void setWeight(int weight) throws TaskCommandException {
        if (weight <= 0) throw new TaskCommandException();
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws TaskCommandException {
        if (age <= 0) throw new TaskCommandException();
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", age=" + getAge() +
                ", color='" + getColor() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
