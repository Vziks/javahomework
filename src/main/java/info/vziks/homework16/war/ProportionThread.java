package info.vziks.homework16.war;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProportionThread implements Runnable {
    private List<String> proportionArray;
    private volatile static Map<String, Integer> stringIntegerHashMap = new HashMap<>();
    Thread thread;

    public ProportionThread(List<String> proportionArray) throws InterruptedException {
        this.proportionArray = proportionArray;
        thread = new Thread(this);
        thread.start();
        thread.join();
    }

    @Override
    public void run() {
        for (String string : proportionArray) {
            stringIntegerHashMap.merge(string, 1, Integer::sum);
        }
    }

    public static Map<String, Integer> getStringIntegerHashMap() {
        return stringIntegerHashMap;
    }
}