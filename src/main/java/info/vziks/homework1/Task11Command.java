package info.vziks.homework1;


import info.vziks.Command;
import info.vziks.exceptions.TaskCommandException;

import java.util.Random;

/**
 * Class Task11Command
 *
 * @author Anton Prokhorov
 */
public class Task11Command implements Command {

    private Random rand;

    private int height;
    private int length;
    private int width;

    /**
     * @param rand Random object
     * @param height Height cuboid. Must be positive.
     * @param length Length cuboid. Must be positive.
     * @param width Width cuboid. Must be positive.
     * @throws TaskCommandException if the height, length, width is not positive
     */
    public Task11Command(Random rand, int height, int length, int width) throws TaskCommandException {
        if (height <= 0 || length <= 0 || width <= 0) {
            throw new TaskCommandException();
        }
        this.rand = rand;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    /**
     * @throws TaskCommandException if method nextInt() of class {@code Random} generate not positive value
     */
    public Task11Command() throws TaskCommandException {
        this.rand = new Random(47);
        this.height = rand.nextInt(100);
        this.length = rand.nextInt(100);
        this.width = rand.nextInt(100);
        if (height <= 0 || length <= 0 || width <= 0) {
            throw new TaskCommandException();
        }
    }

    /**
     *
     */
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
