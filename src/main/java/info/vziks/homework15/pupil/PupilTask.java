package info.vziks.homework15.pupil;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {

    private ArrayList<Pupil> pupilArrayList = new ArrayList<>();
    private Faker faker = new Faker();
    DateFormat format = new SimpleDateFormat("dd/mm/yyyy");

    public PupilTask() throws ParseException {
        init();
    }

    public void init() throws ParseException {

        String dateStringStart = "31/12/2005";
        String dateStringStop = "31/12/1995";

        Integer[] ints = new Integer[100];
        Arrays.setAll(ints, i -> i);
        Collections.shuffle(Arrays.asList(ints));

        for (int i = 0; i < 100; i++) {
            pupilArrayList.add(new Pupil(
                    Arrays.stream(ints).mapToInt(Integer::intValue).toArray()[i],
                    faker.name().firstName(),
                    Pupil.Gender.values()[new Random().nextInt(Pupil.Gender.values().length)],
                    faker.date().between(format.parse(dateStringStop), format.parse(dateStringStart)).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            ));
        }
        pupilArrayList.sort(Comparator.comparing(Pupil::getName));

        for (Pupil pup :
                pupilArrayList) {
            System.out.println(pup);
        }

    }

    public void groupedGender() {
        Map<Pupil.Gender, ArrayList<Pupil>> genderArrayListMap = pupilArrayList.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(genderArrayListMap);
    }

    public double averageAge() {
        return pupilArrayList.stream().map(Pupil::getBirth)
                .mapToDouble(i -> Period.between(i, LocalDate.now()).getYears())
                .average()
                .orElse(Double.NaN);
    }

    public Pupil theSmallestPupil() {
        return pupilArrayList
                .stream()
                .max(Comparator.comparing(Pupil::getBirth))
                .get();
    }

    public Pupil oldestPupil() {
        return pupilArrayList
                .stream()
                .min(Comparator.comparing(Pupil::getBirth))
                .get();
    }

    public Map<Integer, ArrayList<Pupil>> groupByYear() {
        return pupilArrayList.stream()
                .collect(Collectors.groupingBy((i -> i.getBirth().getYear()), Collectors.toCollection(ArrayList::new)));
    }

    public void skipDistinct() {

        pupilArrayList.stream()
                .collect(Collectors
                        .groupingBy(Pupil::getName, Collectors.toCollection(ArrayList::new)))
                .values()
                .stream()
                .filter(pupils -> pupils.size() == 1)
                .map(p -> p.get(0))
                .forEach(pupil -> System.out.printf("%s %s\n", pupil.getName(), pupil.getBirth()));
    }

    public List<Pupil> sortedPupil() {

        Comparator<Pupil> pupilComparator = Comparator
                .comparing(Pupil::getGender)
                .thenComparing(Pupil::getBirth)
                .thenComparing(Pupil::getName, Collections.reverseOrder());

        return pupilArrayList.stream().sorted(pupilComparator)
                .collect(Collectors.toList());
    }

    public List<Pupil> getBetweenAge(int from, int to) {
        return pupilArrayList.stream()
                .filter(i -> Period.between(i.getBirth(), LocalDate.now()).getYears() >= from)
                .filter(i -> Period.between(i.getBirth(), LocalDate.now()).getYears() <= to)
                .collect(Collectors.toList());
    }

    public List<Pupil> getGroupByName(String name) {
        return pupilArrayList.stream()
                .filter(i -> name.equals(i.getName()))
                .collect(Collectors.toList());
    }

    public Map<Pupil.Gender, Integer> getSumByGender() {
        return pupilArrayList.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.summingInt(Pupil::getFullAge)));
    }
}
