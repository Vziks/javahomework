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
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(stopDate);

        int lessons = 0;

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(stopDate);
            endCal.setTime(startDate);
        }

        do {

            startCal.add(Calendar.DAY_OF_MONTH, 1);

            if (list.contains(startCal.get(Calendar.DAY_OF_WEEK))) {

//                Date date = startCal.getTime();
//
//                String day = new SimpleDateFormat("dd/MM/yyyy").format(date);
//
//                System.out.println(day);

                ++lessons;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date
        return lessons;
    }
}
