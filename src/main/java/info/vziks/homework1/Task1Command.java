package info.vziks.homework1;


import info.vziks.homework1.exceptions.Task1CommandExeption;

import java.util.Random;

/**
 * Class Task1
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class Task1Command implements Command {

    private Random rand;

    private int height;
    private int length;
    private int width;

    public Task1Command(Random rand, int height, int length, int width) throws Task1CommandExeption {
        if (height <= 0 || length <= 0 || width <= 0) {
            throw new Task1CommandExeption();
        }
        this.rand = rand;
        this.height = height;
        this.length = length;
        this.width = width;
    }


    public Task1Command() throws Task1CommandExeption {
//        this.rand = new Random(11166);
        this.rand = new Random(47);
        this.height = rand.nextInt(100);
        this.length = rand.nextInt(100);
        this.width = rand.nextInt(100);
        if (height <= 0 || length <= 0 || width <= 0) {
            throw new Task1CommandExeption();
        }
    }

    @Override
    public void execute() {

        System.out.printf("Surface area of a cuboid\nheight %d\nlength %d\nwidth %d\nequals = %d \n%s\n",
                getHeight(),
                getLength(),
                getWidth(),
                getSurfaceArea(getHeight(), getLength(), getWidth()),
                (getWidth() > getHeight()) ? "Width is more than height" : "Height is greater than width"
        );

    }


    /**
     * Gets surface area.
     *
     * @param height the height
     * @param length the length
     * @param width  the width
     * @return the surface area
     */
    public int getSurfaceArea(int height, int length, int width) {
        return (height * length + length * width + width * height) * 2;
    }

    /**
     * Gets rand.
     *
     * @return the rand
     */
    public Random getRand() {
        return rand;
    }

    /**
     * Sets rand.
     *
     * @param rand the rand
     */
    public void setRand(Random rand) {
        this.rand = rand;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }
}
