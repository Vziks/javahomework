package info.vziks.exam.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPILesson {

    public static void main(String[] args) {
//        StreamAPI начиная с 8 версии.
//        Для работы с потоками данных
        // промежуточные операции обрабатывают данные
        // и возвражают Stream объект
        // терминальные обрабатывает данные и завершает работу стрима

//        stream.промежуточный1()
//                .промежуточный2()
//                .промежуточный3()
//                .терминальный();

        // методы получения Stream объектов:
        // из коллекций collection.stream();
        // из массива Arrays.stream(arr);
        // из файла Files.lines(path_to_file);
        // из строки string.chars();
        // используя builder
        // Stream.builder().add(obj1).add(obj2).add(objN).build();
        // Stream.of(1, 4, 7);

        Stream<Integer> integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        integerStream.filter(num -> num < 0)
                .map(num -> num * 10)
                .limit(1)
                .forEach(System.out::println); // -340

        integerStream = Stream.of(5, 7, 89, 89, 21, 34, 21, -89);
        integerStream.distinct() // 5 7 89 21 34 -89
                .sorted() // -89 5 7 21 34 89
                .forEach(System.out::println); // -89 5 7 21 34 89

        // anyMatch | allMatch | noneMatch
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.anyMatch(num -> num == 0)); // true
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.allMatch(num -> num > 100)); // false
        integerStream = Stream.of(6, 8, 90, -34, 0, -12);
        System.out.println(integerStream.noneMatch(num -> num > 100)); // true

        String[] stringsArr = {"aa", "bb", "cc", "dd"};

        // findFirst | findAny
        Arrays.stream(stringsArr).findFirst().get();// Optional<T>
        Arrays.stream(stringsArr).findFirst().orElse("default");// Optional<T>
        Arrays.stream(stringsArr).findFirst().isPresent();

        Arrays.stream(stringsArr).skip(20)
                .filter(str -> str.startsWith("c"))
                .forEach(System.out::println);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("qwe", 34));
        users.add(new User("asd", 56));
        users.add(new User("zxc", 18));
        users.add(new User("qwe", 34));
        users.add(new User("zxc", 22));

        // массив пользователей старше 25
        User[] usersArr = users.stream()
                .filter(user -> user.getAge() > 25)
                .toArray(User[]::new); // new User[]

        List<User> userList = users.stream()
                .filter(user -> user.getAge() < 25)
                .peek(user -> user.setActive(true))
                .collect(Collectors.toList());
        Set<User> userSet = users.stream()
                .filter(user -> user.getAge() > 25)
                .collect(Collectors.toSet());

        ArrayList<User> userArrayList = users.stream()
                .distinct()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toCollection(ArrayList::new));

        User minUser = users.stream()
                .min(Comparator.comparing(User::getName))
                .orElse(new User("default", 0));

        User maxUser = users.stream()
                .max(Comparator.comparing(User::getName))
                .orElse(new User("default", 100));
        System.out.println("maxUser: " + maxUser);

        String[] stringsArr2 = {"aaa", "cc", "cc", "dddd", "f"};

        Map<String, Integer> map = Arrays.stream(stringsArr2)
                .collect(Collectors.toMap(
                        Function.identity(), //
                        String::length, //
                        (item1, item2) -> item1)); //


        Stream<Integer> integerStream01 = Stream.of(2, 4, 5, 2, 34, 5);
        Optional<Integer> optional = integerStream01.reduce(Integer::sum);
        integerStream01 = Stream.of(2, 4, 5, 2, 34, 5);
        Integer optional1 = integerStream01.reduce(20, (x, y) -> x + y);


        integerStream01 = Stream.of(2, 4, 5, 2, 34, 5);
        int asas = integerStream01.reduce(20, (x, y) -> {
            if (x < 0 || y < 0) return 0;
            else return x + y;
        }, (x, y) -> x + y);

        System.out.println(asas);
    }
}

class User {
    private String name;
    private int age;
    private boolean active;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (isActive() != user.isActive()) return false;
        return getName() != null ? getName().equals(user.getName()) : user.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (isActive() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
