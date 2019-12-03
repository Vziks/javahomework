package info.vziks.homework15;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework15.student.StudentTask;
import info.vziks.utils.Command;

import java.text.ParseException;

public class Task151Command implements Command {
    @Override
    public void execute() throws TaskCommandException {
        try {
            StudentTask studentTask = new StudentTask();
            studentTask.getUniqueProfession();
        } catch (TaskCommandException | ParseException e) {
            e.printStackTrace();
        }
    }
}
