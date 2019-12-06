package info.vziks.lessons.annotation.work.two;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
        Set<Class> classes = new HashSet<>();
        classes.add(ServerSettings.class);
        classes.add(Server.class);
        Container container = new Container(classes);
        container.init();

    }
}
