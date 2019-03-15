package info.vziks.homework1;

import info.vziks.utils.Command;

/**
 * Class Task12Command
 *
 * @author Anton Prokhorov
 */
public class Task12Command implements Command {

    private int plotSize;
    private int gardenBeX;
    private int gardenBedY;

    public Task12Command() {
        this.plotSize = 10;
        this.gardenBeX = 15;
        this.gardenBedY = 25;
    }

    public Task12Command(int plotSize, int gardenBeX, int gardenBedY) {
        this.plotSize = plotSize;
        this.gardenBeX = gardenBeX;
        this.gardenBedY = gardenBedY;
    }

    @Override
    public void execute() {
        System.out.println("Unoccupied square " + remainderSquare(squarePlotSize(getPlotSize()), getGardenBeX(), getGardenBedY()));
    }

    public int remainderSquare(int squarePlotSize, int gardenBedY, int cardenBedY) {
        return squarePlotSize % gardenBedY * cardenBedY;
    }

    public int squarePlotSize(int pltSz) {
        return pltSz * 10 * 10;
    }

    public int getPlotSize() {
        return plotSize;
    }

    public void setPlotSize(int plotSize) {
        this.plotSize = plotSize;
    }

    public int getGardenBeX() {
        return gardenBeX;
    }

    public void setGardenBeX(int gardenBeX) {
        this.gardenBeX = gardenBeX;
    }

    public int getGardenBedY() {
        return gardenBedY;
    }

    public void setGardenBedY(int gardenBedY) {
        this.gardenBedY = gardenBedY;
    }
}
