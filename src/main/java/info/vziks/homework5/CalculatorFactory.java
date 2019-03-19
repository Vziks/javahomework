package info.vziks.homework5;

import java.util.HashMap;
import java.util.Map;

public class CalculatorFactory {

    Map<String, CalculatorInterface> map = new HashMap<>();

    void add(CalculatorInterface cinterface, String simbol) {
        map.put(simbol, cinterface);
    }

    CalculatorInterface getInstance(String simbol) {
        return map.get(simbol);
    }

    ;

}
