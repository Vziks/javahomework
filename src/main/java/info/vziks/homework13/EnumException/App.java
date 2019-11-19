package info.vziks.homework13.EnumException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {

    private Map<Status, CheckInterface> hashMap = new HashMap<>();

    public App() {
        for (Status op : Status.values()) {
            hashMap.put(op, op.getCheckInterface());
        }
    }

    public Map<Status, CheckInterface> getHashMap() {
        return hashMap;
    }

    public static void printError(IOException io) {
        String exceptionClassName = io.getClass().getSimpleName();
        switch (exceptionClassName) {
            case "FileNotFoundException":
            case "JarException":
                io.printStackTrace();
                break;
            case "AccessDeniedException":
                System.out.println(io.getMessage());
                try {
                    throw new Exception("CheckedException");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("cause: " + e1.getCause());
                }
                break;
        }
    }
}
