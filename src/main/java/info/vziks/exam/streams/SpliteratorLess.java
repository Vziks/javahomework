package info.vziks.exam.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorLess {
    public static void main(String[] args) {

        List<String> stringArrayList = Arrays.asList("a","s","q","t","e");

        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.CONCURRENT));
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.DISTINCT));
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.NONNULL));
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.IMMUTABLE));
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.ORDERED));
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.SUBSIZED));


        Spliterator<String> stringSpliterator = stringArrayList.spliterator();


        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());
//        stringSpliterator.forEachRemaining(System.out::println);
        stringSpliterator.trySplit();
        stringSpliterator.forEachRemaining(System.out::println);

        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());


        Spliterator<String> stringSpliterator1 = stringArrayList.spliterator();
        Spliterator<String> stringSpliterator2 = stringSpliterator1.trySplit();

        System.out.println();

        stringSpliterator1.forEachRemaining(System.out::println);
        System.out.println("++");
        stringSpliterator2.forEachRemaining(System.out::println);


    }
}
