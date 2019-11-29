package info.vziks.exam.streams;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsLesson {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = StreamsLesson.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("wp.txt")).getFile());

        Stream<String> fullText = Files.lines(file.toPath());

        Map<String, Long> long11 = fullText.map(String::toLowerCase)
                .flatMap(line -> Arrays.stream(
                        line.replaceAll("\\p{Punct}", "").trim().split("\\s"))
                )
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ))
                .entrySet()
                .parallelStream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(long11);


    }
}
