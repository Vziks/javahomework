package info.vziks.homework9.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lessons {

    public static int getLessonsBetweenTwoDates(Date startDate, Date stopDate) throws ParseException {

        Integer[] days = new Integer[]{Calendar.MONDAY, Calendar.WEDNESDAY, Calendar.FRIDAY};

        String sDate1 = "31/12/2019";
        String sDate2 = "09/01/2020";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date startDateNov = simpleDateFormat.parse(sDate1);
        Date stopDateNov = simpleDateFormat.parse(sDate2);

        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDateNov);

        Calendar endCalendarNov = new GregorianCalendar();
        endCalendarNov.setTime(stopDateNov);

        while (calendar.before(endCalendarNov)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }

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

        for (Date item :
                datesInRange) {
            System.out.println(item);
        }

        do {

            startCalendar.add(Calendar.DAY_OF_MONTH, 1);


            Date dt = startCalendar.getTime();


            if (list.contains(startCalendar.get(Calendar.DAY_OF_WEEK)) && !datesInRange.contains(dt)) {
                ++lessons;
            }
        } while (startCalendar.getTimeInMillis() < endCalendar.getTimeInMillis()); //excluding end date
        return lessons;
    }
}
