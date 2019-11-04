package info.vziks.homework9.datetime;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Lessons {

    public static int getLessonsBetweenTwoDates(Date startDate, Date stopDate) {

        Integer[] days = new Integer[]{Calendar.MONDAY, Calendar.WEDNESDAY, Calendar.FRIDAY};

        List<Integer> list = Arrays.asList(days);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(stopDate);

        int lessons = 0;

        if (startCalendar.getTimeInMillis() == endCalendar.getTimeInMillis()) {
            return 0;
        }

        if (startCalendar.getTimeInMillis() > endCalendar.getTimeInMillis()) {
            startCalendar.setTime(stopDate);
            endCalendar.setTime(startDate);
        }

        do {

            startCalendar.add(Calendar.DAY_OF_MONTH, 1);

            if (list.contains(startCalendar.get(Calendar.DAY_OF_WEEK))) {

//                Date date = startCalendar.getTime();
//
//                String day = new SimpleDateFormat("dd/MM/yyyy").format(date);
//
//                System.out.println(day);

                ++lessons;
            }
        } while (startCalendar.getTimeInMillis() < endCalendar.getTimeInMillis()); //excluding end date
        return lessons;
    }
}
