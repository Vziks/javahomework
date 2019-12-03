package info.vziks.homework15.student;

import com.github.javafaker.Faker;
import javafx.util.Pair;

import java.sql.Array;
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
        for (int i = 0; i < 100; i++) {
            Student student = new Student(
                    faker.name().username()
            );
            for (int j = 0; j < 3; j++) {
                student.addProfession(faker.company().profession());
            }

            studentArrayList.add(student);
        }


        for (Student item :
                studentArrayList) {
            System.out.println(item);

        }
    }

    public void getUniqueProfession() {

        studentArrayList
                .stream()
                .flatMap(std -> std.getProfessions().stream()
                        .map(sbj -> new Pair<>(sbj, std)))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (a, b) -> null))
                .values()
                .stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
