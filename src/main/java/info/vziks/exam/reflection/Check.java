package info.vziks.exam.reflection;

import java.io.Serializable;

public class Check {
}

class Parent {
    protected int id;

    public Parent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}


class Child extends Parent implements Serializable {
    public Child(int id) {
        super(id);
        this.id = 11;
    }
}


class ChildChild extends Child {
    public ChildChild(int id) {
        super(id);
        this.id = 12;
    }
}