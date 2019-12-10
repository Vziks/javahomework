package info.vziks.homework16.war;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MultiParser {
    private ClassLoader loader;
    private File file;
    private List<String> lines;
    private List<String> fullStringArray = new ArrayList<>();
    private Map<Integer, ProportionThread> integerProportionThreadMap = new HashMap<>();
    private Map<String, Integer> stringIntegerHashMap = new HashMap<>();

    private int proportion;
    private int availableProcessors;

    public MultiParser(String fileName) throws IOException {
        setLoader(MultiParser.class.getClassLoader());
        file = new File(Objects.requireNonNull(loader.getResource(fileName)).getFile());
        lines = Files.readAllLines(getFile().toPath());
        setAvailableProcessors(Runtime.getRuntime().availableProcessors());
    }

    public void init() throws InterruptedException {
        fillStringArray();
        setProportion();
        distributeThread();
        combine();
    }

    public void start() throws InterruptedException {
        init();
    }

    private void combine() {
        for (Map.Entry<Integer, ProportionThread> entityProportion : integerProportionThreadMap.entrySet()) {
            for (Map.Entry<String, Integer> entity : entityProportion.getValue().getStringIntegerHashMap().entrySet()) {
                stringIntegerHashMap.merge(entity.getKey(), entity.getValue(), Integer::sum);
            }
        }
    }

    private void setProportion() {
        this.proportion = fullStringArray.size() / availableProcessors;
    }


    public MultiParser setAvailableProcessors(int availableProcessors) {
        this.availableProcessors = availableProcessors;
        return this;
    }

    private void distributeThread() throws InterruptedException {
        for (int i = 0; i < this.availableProcessors; i++) {
            integerProportionThreadMap.put(i, new ProportionThread(
                    fullStringArray.subList(i * proportion,
                            this.availableProcessors == i + 1 ? fullStringArray.size() : ((i + 1) * proportion) - 1)));
        }
    }

    private void fillStringArray() {
        for (String line : lines) {
            if (!"".equals(line)) {
                String[] wordsSplit = line
                        .toLowerCase()
                        .replaceAll("\\p{Punct}", "")
                        .replaceAll("\n", " ")
                        .replaceAll("\r", " ")
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

    private MultiParser setLoader(ClassLoader loader) {
        this.loader = loader;
        return this;
    }

    private File getFile() {
        return file;
    }

    private Map<String, Integer> getStringIntegerHashMap() {
        return stringIntegerHashMap;
    }

    public void printTop100Words() {

        System.out.println("Top 100 words");
        getStringIntegerHashMap()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(100)
                .forEach(System.out::println);
    }
}
