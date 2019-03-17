package info.vziks.homework4.figures;

public class Circle extends Figure {
    private int radius;

    public Circle(int x, int y, int radius) {
        setX(x);
        setX(y);
        setRadius(radius);
    }

    @Override
    public double getSquare() {
        return Math.PI * (getRadius() * getRadius());
    }

    @Override
    public double getPerimeter() {
        return Math.PI * getRadius() * 2;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
