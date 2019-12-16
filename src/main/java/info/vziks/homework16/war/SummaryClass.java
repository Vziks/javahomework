package info.vziks.homework16.war;

import java.util.HashMap;
import java.util.Map;

public class SummaryClass {
    private Map<String, Integer> stringIntegerHashMap = new HashMap<>();

    public synchronized void add(String string){
        stringIntegerHashMap.merge(string, 1, Integer::sum);
    }

    public synchronized Map<String, Integer> getStringIntegerHashMap() {
        return stringIntegerHashMap;
    }
}
