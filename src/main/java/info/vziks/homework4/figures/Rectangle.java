package info.vziks.homework4.figures;

public class Rectangle extends Figure {
    private int x1;

    private int y1;

    public Rectangle(int x, int y, int x1, int y1) {
        setX(x);
        setX(y);
        setX1(x1);
        setY1(y1);
    }

    @Override
    public double getSquare() {
        return Math.abs((this.getX1() - this.getX()) * (this.getY1() - this.getY()));
    }

    @Override
    public double getPerimeter() {
        return (Math.abs((this.getX1() - this.getX())) + Math.abs((this.getY1() - this.getY()))) * 2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
}
