package info.vziks.homework16.war;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MultiParser {

    private ClassLoader loader = MultiParser.class.getClassLoader();
    private File file;
    // Repository of all words from a file
    private List<String> fullStringArray = new ArrayList<>();
    // Array of ProportionThread instance
    private List<ProportionThread> proportionThreadArrayList = new ArrayList<>();
    // Summary HashMap <Word, Count>
    private Map<String, Integer> stringIntegerHashMap = new HashMap<>();
    // Number of records seized
    private int proportion;
    // Number of threads, default available processors
    private int numberOfThreads = Runtime.getRuntime().availableProcessors();

    public MultiParser(String fileName) {
        file = new File(Objects.requireNonNull(loader.getResource(fileName)).getFile());
    }

    private void init() throws InterruptedException, IOException {
        fillStringArray();
        setProportion();
        distributeThread();
        combine();
    }

    public void start() throws InterruptedException, IOException {
        init();
    }

    private void combine() {
        for (ProportionThread item :
                proportionThreadArrayList) {
            for (Map.Entry<String, Integer> entity : item.getStringIntegerHashMap().entrySet()) {
                stringIntegerHashMap.merge(entity.getKey(), entity.getValue(), Integer::sum);
            }
        }
    }

    private void setProportion() {
        this.proportion = fullStringArray.size() / numberOfThreads;
    }

    public MultiParser setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        return this;
    }

    private void distributeThread() throws InterruptedException {

        for (int i = 0, check = 1; i < this.numberOfThreads; i++, check++) {
            proportionThreadArrayList.add(new ProportionThread(
                    fullStringArray.subList(i * proportion,
                            this.numberOfThreads == check ? fullStringArray.size() : check * proportion - 1)));
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
        System.out.println("Top 100 words");
        stringIntegerHashMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(100)
                .forEach(System.out::println);
    }
}