package info.vziks.exam.streams;

import java.util.Arrays;
import java.util.Collection;

public class Start {
    public static void main(String[] args) {

        Collection<SportsCamp> sport = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );
        /**
         * Пример 3
         * Поиск имени самого большого по продолжительности нахождения в лагере
         */
        String name = sport.stream().max((p1,p2) -> p1.getDay().compareTo(p2.getDay())).get().getName();
        System.out.println("Name="+name);
    }
}
