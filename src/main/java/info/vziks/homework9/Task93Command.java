package info.vziks.homework9;

import info.vziks.homework9.datetime.Lessons;
import info.vziks.utils.Command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task93Command implements Command {
    @Override
    public void execute() throws ParseException {


        String sDate = "20/02/2020";

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Date start = formatter.parse(dateTimeFormatter.format(now));

        Date stop = formatter.parse(sDate);

        System.out.println(Lessons.getLessonsBetweenTwoDates(start, stop));
    }
}
