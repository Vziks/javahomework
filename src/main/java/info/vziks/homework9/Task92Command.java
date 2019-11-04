package info.vziks.homework9;

import info.vziks.homework9.datetime.FactoryTime;
import info.vziks.utils.Command;

public class Task92Command implements Command {
    @Override
    public void execute() {

        FactoryTime.init();

        System.out.println("FactoryTime.getShiftByTime() = " + FactoryTime.getShiftByTime());

    }
}
