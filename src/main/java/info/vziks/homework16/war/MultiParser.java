package info.vziks.homework16.war;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiParser {

    private ClassLoader loader = MultiParser.class.getClassLoader();
    private File file;
    // Repository of all words from a file
    private List<String> fullStringArray = new ArrayList<>();
    // Array of ProportionThread instance
//    private Map<Integer, Future> integerFutureMap = new HashMap<>();
    private List<Future> integerFutureMap = new ArrayList<>();
    // Number of records seized
    private int proportion;
    // Number of threads, default available processors
    private int numberOfThreads = Runtime.getRuntime().availableProcessors();
    // summaryClass
    SummaryClass summaryClass = new SummaryClass();

    ExecutorService service = Executors.newCachedThreadPool();

    public MultiParser(String fileName) {
        try {
            file = new File(Objects.requireNonNull(loader.getResource(fileName)).getFile());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        fillStringArray();
        setProportion();
        distributeThread();
    }

    public void start() throws IOException {
        init();
    }

    private void setProportion() {
        this.proportion = fullStringArray.size() / numberOfThreads;
    }

    public MultiParser setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        return this;
    }

    private void distributeThread() {

        for (int i = 0, check = 1; i < this.numberOfThreads; i++, check++) {
            integerFutureMap.add(service.submit(new ProportionThread(
                    fullStringArray.subList(i * proportion,
                            numberOfThreads == check ? fullStringArray.size() - 1 : check * proportion), summaryClass)));
        }
    }

    private void fillStringArray() throws IOException {

        for (String line : Files.readAllLines(file.toPath())) {
            if (!"".equals(line)) {
                String[] wordsSplit = line
                        .toLowerCase()
                        .replaceAll("\\p{Punct}", "")
                        .trim()
                        .split("\\s");
                try {
                    fullStringArray.addAll(Arrays.asList(wordsSplit));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printTop100Words() {

        integerFutureMap.forEach((a) -> {
            try {
                a.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();


        System.out.println("Top 100 words");

        summaryClass.getStringIntegerHashMap()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(100)
                .forEach(System.out::println);
    }
}