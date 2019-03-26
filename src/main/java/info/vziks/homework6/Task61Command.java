package info.vziks.homework6;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework6.pupil.Pupil;
import info.vziks.utils.Command;

public class Task61Command implements Command {
    @Override
    public void execute() {
        Pupil pupil = new Pupil("Leo");
        String[] ex = {"Mathematics", "History", "Informatics"};
        int[] marks = {4, 5, 2};
        pupil.setExams(ex, marks);
        System.out.println(pupil);
    }
}
