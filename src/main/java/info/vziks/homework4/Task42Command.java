package info.vziks.homework4;

import info.vziks.homework4.figures.Circle;
import info.vziks.homework4.figures.Rectangle;
import info.vziks.homework4.figures.Triangle;
import info.vziks.utils.Command;

import java.util.Random;

public class Task42Command implements Command {

    private Random rnd = new Random(47);

    private Triangle[] triangles = new Triangle[3];
    private Rectangle[] rectangles = new Rectangle[3];
    private Circle[] circles = new Circle[3];

    public Task42Command() {
        init();
    }

    private void init() {
        generateTriangles();
        generateRectangles();
        generateCircles();
    }

    @Override
    public void execute() {
        showCircles();
        showTriangles();
        showRectangles();
    }

    private void showRectangles() {
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle square:" + rectangles[i].getSquare());
            System.out.println("Rectangle perimeter:" + rectangles[i].getPerimeter());
        }
    }

    public void showCircles() {
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Circle square:" + circles[i].getSquare());
            System.out.println("Circle perimeter:" + circles[i].getPerimeter());
        }
    }

    public void showTriangles() {
        for (int i = 0; i < triangles.length; i++) {
            System.out.println("Triangle square:" + triangles[i].getSquare());
            System.out.println("Triangle perimeter:" + triangles[i].getPerimeter());
        }
    }

    public Random getRnd() {
        return rnd;
    }

    public void generateTriangles() {
        for (int i = 0; i < triangles.length; i++) {
            triangles[i] = new Triangle(
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100));
        }
    }

    public void generateRectangles() {
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle(
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100));
        }
    }

    public void generateCircles() {
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(
                    rnd.nextInt(100),
                    rnd.nextInt(100),
                    rnd.nextInt(100));
        }
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

}
