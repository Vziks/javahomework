package info.vziks.homework9.datetime;

import javafx.util.Pair;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class FactoryTime {
    private static Map<String, Pair<String, String>> map = new HashMap<>();

    public static void init() {
        map.put("1 смена", new Pair<>("07:00", "15:00"));
        map.put("2 смена", new Pair<>("15:00", "23:00"));
        map.put("3 смена", new Pair<>("23:00", "07:00"));
    }

    public static String getShiftByTime() {

        String result = null;
        for (Map.Entry<String, Pair<String, String>> entry : map.entrySet()) {

            if (checkTime(entry.getValue().getKey(), entry.getValue().getValue())) {
                result = entry.getKey();
            }
        }

        return result;
    }

    public static boolean checkTime(String start, String stop) {
        LocalTime target = LocalTime.now();
        return target.isAfter(LocalTime.parse(start))
                &&
                target.isBefore(LocalTime.parse(stop));
    }


}
