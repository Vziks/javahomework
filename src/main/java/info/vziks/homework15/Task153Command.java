package info.vziks.homework15;

import info.vziks.exceptions.TaskCommandException;
import info.vziks.homework15.pupil.Pupil;
import info.vziks.homework15.pupil.PupilTask;
import info.vziks.utils.Command;

import java.text.ParseException;

public class Task153Command implements Command {
    @Override
    public void execute() throws TaskCommandException {
        try {
            PupilTask pupilTask = new PupilTask();
//            1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
            pupilTask.groupedGender();
//            2. Найти средний возраст учеников
            System.out.println(pupilTask.averageAge());
//            3. Найти самого младшего ученика
            System.out.println(pupilTask.theSmallestPupil());
//            4. Найти самого старшего ученика
            System.out.println(pupilTask.oldestPupil());
//            5. Собрать учеников в группы по году рождения
            System.out.println(pupilTask.groupByYear());
//            6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
            System.out.println("skipDistinct");
            pupilTask.skipDistinct();

//            7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
            System.out.println();

            for (Pupil pupil :
                    pupilTask.sortedPupil()) {
                System.out.println(pupil);

            }

//            8. Вывести в косоль всех учеников в возрасте от N до M лет
            System.out.println();
            for (Pupil pupil :
                    pupilTask.getBetweenAge(19, 20)) {
                System.out.println(pupil);
            }

//            9. Собрать в список всех учеников с именем=someName
            System.out.println();
            for (Pupil pupil :
//                    pupilTask.getGroupByName("Ivory")) {
                    pupilTask.getGroupByName(null)) {
                System.out.println(pupil);
            }
            System.out.println();
//            10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
            System.out.println(pupilTask.getSumByGender());

        } catch (TaskCommandException | ParseException e) {
            e.printStackTrace();
        }
    }
}
