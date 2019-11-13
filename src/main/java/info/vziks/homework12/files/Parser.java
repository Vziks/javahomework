package info.vziks.homework12.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Parser {
    private ClassLoader loader;
    private File file;
    private List<String> lines;

    private long fullSum = 0;


    private Map<String, Integer> stringIntegerHashMap = new HashMap<>();
    private Map<Integer, ArrayList<String>> integerArrayListHashMap = new HashMap<>();
    private Map<Integer, Set<String>> integerSetHashMap = new HashMap<>();
    private Map<Character, Integer> characterIntegerHashMap = new HashMap<>();
    private TreeMap<String, Integer> stringIntegerTreeMap;


    public Parser(String fileName) throws IOException {
        setLoader(Parser.class.getClassLoader());
        this.file = new File(Objects.requireNonNull(loader.getResource(fileName)).getFile());
        this.lines = Files.readAllLines(getFile().toPath());
    }


    public void init() {
        char[] tmp;
        for (String line : lines) {
            String[] wordsSplit = line
                    .toLowerCase()
                    .replaceAll("\\p{Punct}", "")
                    .trim()
                    .split("\\s");


            for (String str : wordsSplit) {

                if (!"".equals(str) & !Parser.isNumeric(str)) {
                    stringIntegerHashMap.put(str, (stringIntegerHashMap.containsKey(str) ? stringIntegerHashMap.get(str) + 1 : 1));

                    if (integerArrayListHashMap.get(str.length()) == null) {
                        integerArrayListHashMap.put(str.length(), new ArrayList<>(Collections.singletonList(str)));
                    } else {
                        integerArrayListHashMap.get(str.length()).add(str);
                    }

                    if (integerSetHashMap.get(str.length()) == null) {
                        integerSetHashMap.put(str.length(), new HashSet<>(Collections.singletonList(str)));
                    } else {
                        integerSetHashMap.get(str.length()).add(str);
                    }

                    tmp = str.toCharArray();
                    for (char c : tmp) {
                        if (!Parser.isNumeric(String.valueOf(c))) {
                            characterIntegerHashMap.put(c, (characterIntegerHashMap.containsKey(c) ? characterIntegerHashMap.get(c) + 1 : 1));
                        }
                    }
                }
            }
        }

        setFullSum();
        sort();
    }

    public void sort() {
        ValueComparator valueComparator = new ValueComparator(getStringIntegerHashMap());
        stringIntegerTreeMap = new TreeMap<>(valueComparator);

        stringIntegerTreeMap.putAll(stringIntegerHashMap);
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public Parser setLoader(ClassLoader loader) {
        this.loader = loader;
        return this;
    }

    public File getFile() {
        return file;
    }

    public Map<String, Integer> getStringIntegerHashMap() {
        return stringIntegerHashMap;
    }

    public Map<Integer, ArrayList<String>> getIntegerArrayListHashMap() {
        return integerArrayListHashMap;
    }

    public Map<Integer, Set<String>> getIntegerSetHashMap() {
        return integerSetHashMap;
    }

    public Map<Character, Integer> getCharacterIntegerHashMap() {
        return characterIntegerHashMap;
    }

    public TreeMap<String, Integer> getStringIntegerTreeMap() {
        return stringIntegerTreeMap;
    }

    public void getTopTenWords() {
        int count = 0;
        System.out.println("Top 10 words");
        for (Map.Entry<String, Integer> entity : getStringIntegerTreeMap().entrySet()) {
            if (count >= 10) {
                break;
            }
            System.out.println(entity);
            count++;
        }
    }

    public void getWordLengthStatistics() {
        System.out.println("Word length statistics");
        for (Map.Entry<Integer, ArrayList<String>> entity : getIntegerArrayListHashMap().entrySet()) {
            System.out.printf("%d words of %d letters\n", entity.getValue().size(), entity.getKey());
        }
    }

    public void getWordGroupStatistics() {
        System.out.println("Word group statistics");
        for (Map.Entry<Integer, Set<String>> entity : getIntegerSetHashMap().entrySet()) {
            System.out.println(entity.getValue());
        }
    }

    public void setFullSum() {
        for (Map.Entry<Character, Integer> entity : getCharacterIntegerHashMap().entrySet()) {
            fullSum += entity.getValue();
        }
    }

    public void getCharacterStatistics() {
        System.out.println("Character statistics");

        for (Map.Entry<Character, Integer> entity : getCharacterIntegerHashMap().entrySet()) {
            System.out.printf("Character %s count %d\n", entity.getKey(), entity.getValue());
        }
    }

    public void getProportionalRatio() {
        for (Map.Entry<Character, Integer> entity : getCharacterIntegerHashMap().entrySet()) {
            System.out.printf("letter %s in a proportional ratio - %.3f \n", entity.getKey(),
                    entity.getValue() * 100f / fullSum
            );
        }
    }
}
