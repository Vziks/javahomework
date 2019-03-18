package info.vziks.homework4.figures;

public class Triangle extends Figure {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Triangle(int x, int y, int x1, int y1, int x2, int y2) {
        this.setX(x);
        this.setX1(x1);
        this.setX2(x2);

        this.setY(y);
        this.setY1(y1);
        this.setY2(y2);
    }

    @Override
    public double getSquare() {
        return Math.abs(0.5 * (
                Math.abs((this.getX() - this.getX2()) * (this.getY1() - this.getY2())) -
                        Math.abs((this.getX() - this.getX2()) * (this.getY() - this.getY2()))
        ));
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(
                Math.pow(this.getX() - this.getX2(), 2) +
                        Math.pow(this.getY() - this.getY2(), 2)) +
                Math.sqrt(
                        Math.pow(this.getX1() - this.getX(), 2) +
                                Math.pow(this.getY1() - this.getY(), 2)) +
                Math.sqrt(
                        Math.pow(this.getX2() - this.getX1(), 2) +
                                Math.pow(this.getY2() - this.getY1(), 2))
                ;
    }

    public double getSqrt(int i, int j) {
        return Math.sqrt(
                Math.pow(this.getX2() - this.getX(), 2) +
                        Math.pow(this.getY2() - this.getY(), 2));
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

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
