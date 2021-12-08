package lab7.frekvencijaNaZborovi;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TermFrequency {
    private final Map<String, Integer> map;
    private int count;

    public TermFrequency(InputStream in, String[] stopWords) {
        Scanner scanner = new Scanner(in);
        this.map = new HashMap<>();
        this.count = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            word = word
                    .toLowerCase()
                    .replaceAll("[,.-]", "")
                    .trim();

            if (!Arrays.asList(stopWords).contains(word) && !word.isEmpty()) {
                map.computeIfPresent(word, (k, v) -> ++v);
                map.putIfAbsent(word, 1);

                count++;
            }
        }
    }

    public int countTotal() {
        return count;
    }

    public int countDistinct() {
        return map.size();
    }

    public List<String> mostOften(int k) {
        return map.keySet().stream().sorted(Comparator.comparing(map::get).reversed().thenComparing(Object::toString)).limit(k).collect(Collectors.toList());
    }
}