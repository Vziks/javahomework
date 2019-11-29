package info.vziks.exam.streams;

import java.util.*;
import java.util.stream.Collectors;

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
        String name = sport.stream().max(Comparator.comparing(SportsCamp::getDay)).get().getName();
        System.out.println("Name=" + name);

        ArrayList list = sport.stream().filter((x) -> x.getDay() > 5).filter((x) -> "Ira".equals(x.getName()))
                .collect(Collectors.toCollection(ArrayList::new));

//        Map<String,Integer> list1 = sport.stream().filter((x) -> x.getDay() > 5).filter((x) -> "Ira".equals(x.getName()))
//                .collect(Collectors.toMap(ArrayList::new));
//        ArrayList list = sport.stream().filter((x) -> x.getDay() > 5 & x.getDay() < 10)
//                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(list);


    }
}
