package info.vziks.lessons.annotation.work.one;

import java.lang.reflect.Field;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {


        SomeClass someClass1 = new SomeClass("someClass1", 5, 10);
        SomeClass someClass2 = new SomeClass("someClass2", 6, 12);
        SomeClass someClass3 = new SomeClass("someClass3", 7, 14);

        toString(someClass1);
        toString(someClass2);
        toString(someClass3);

    }


    static void toString(SomeClass someClass) throws IllegalAccessException {

        Field[] fields = someClass.getClass().getDeclaredFields();
        for (Field item :
                fields) {

            if (!item.isAnnotationPresent(Ignore.class)) {
                if (!item.isAccessible()){
                    item.setAccessible(true);
                }
                System.out.println();
                System.out.printf("Название %s:  значение %s", item.getName(), item.get(someClass));
            }

        }

    }
}
