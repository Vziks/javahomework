package info.vziks.homework15.student;

import com.github.javafaker.Faker;
import javafx.util.Pair;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;


public class StudentTask {

    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private Faker faker = new Faker();

    public StudentTask() throws ParseException {
        init();
    }

    private void init() {
        for (int i = 0; i < 200; i++) {
            Student student = new Student(
                    faker.name().username()
            );
            for (int j = 0; j < 3; j++) {
                student.addProfession(faker.company().profession());
            }

            studentArrayList.add(student);
        }


//        for (Student item :
//                studentArrayList) {
//            System.out.println(item);
//
//        }
    }

    public void getUniqueProfession() {
        studentArrayList
                .stream()
                .flatMap(st -> st.getProfessions().stream().map(subj -> new Pair<>(subj, st)))
                .collect(Collectors.toMap(
                        Pair::getKey,
                        x -> {
                            List<Student> list = new ArrayList<>();
                            list.add(x.getValue());
                            return list;
                        },
                        (a, b) -> {
                            a.addAll(b);
                            return a;
                        }
                ))
                .values()
                .stream()
                .filter(s -> s.size() == 1)
                .forEachOrdered(System.out::println);

    }
}
