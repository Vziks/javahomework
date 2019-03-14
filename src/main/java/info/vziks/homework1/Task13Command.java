package info.vziks.homework1;

import info.vziks.utils.Command;

/**
 * Class Task13Command
 *
 * @author Anton Prokhorov
 */
public class Task13Command implements Command {

    private int ellipseSquareDm = 15;

    private int ellipseSquareSm = 600;

    /**
     * Area difference int.
     *
     * @param ellSqDm  the ell sq dm
     * @param ellSquSm the ell squ sm
     * @return the int
     */
    public int areaDifference(int ellSqDm, int ellSquSm) {
        return ellSqDm * 100 - ellSquSm;
    }

    @Override
    public void execute() {
        System.out.printf("Ring area %d\n", areaDifference(getEllipseSquareDm(), getEllipseSquareSm()));
    }

    /**
     * Gets ellipse square dm.
     *
     * @return the ellipse square dm
     */
    public int getEllipseSquareDm() {
        return ellipseSquareDm;
    }

    /**
     * Gets ellipse square sm.
     *
     * @return the ellipse square sm
     */
    public int getEllipseSquareSm() {
        return ellipseSquareSm;
    }

    /**
     * Sets ellipse square dm.
     *
     * @param ellipseSquareDm the ellipse square dm
     */
    public void setEllipseSquareDm(int ellipseSquareDm) {
        this.ellipseSquareDm = ellipseSquareDm;
    }

    /**
     * Sets ellipse square sm.
     *
     * @param ellipseSquareSm the ellipse square sm
     */
    public void setEllipseSquareSm(int ellipseSquareSm) {
        this.ellipseSquareSm = ellipseSquareSm;
    }
}
