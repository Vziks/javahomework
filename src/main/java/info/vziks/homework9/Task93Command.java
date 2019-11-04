package info.vziks.homework9;

import info.vziks.homework9.datetime.Lessons;
import info.vziks.utils.Command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task93Command implements Command {
    @Override
    public void execute() throws ParseException {


        String sDate = "20/02/2020";

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date stop = formatter.parse(sDate);

        Date start = new Date(System.currentTimeMillis());

        System.out.println(Lessons.getLessonsBetweenTwoDates(start, stop));
    }
}
