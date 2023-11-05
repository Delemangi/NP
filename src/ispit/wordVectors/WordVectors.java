package ispit.wordVectors;

import java.util.*;
import java.util.stream.*;

public class WordVectors {
    private final Map<String, Vectors> wordVectors;
    private List<Vectors> translatedWords;

    public WordVectors(String[] words, List<List<Integer>> vectors) {
        this.wordVectors = new HashMap<>();
        IntStream.range(0, vectors.size()).forEach(i -> wordVectors.put(words[i], new Vectors(vectors.get(i))));
    }

    public void readWords(List<String> wordsList) {
        translatedWords = wordsList
                .stream()
                .map(word -> wordVectors
                        .getOrDefault(word, new Vectors(Vectors.NEUTRAL)))
                .collect(Collectors.toList());
    }

    public List<Integer> slidingWindow(int n) {
        return IntStream
                .range(0, translatedWords.size() - n + 1)
                .mapToObj(i -> translatedWords.subList(i, i + n)
                        .stream()
                        .reduce(new Vectors(Vectors.DEFAULT), Vectors::sum))
                .map(Vectors::max)
                .collect(Collectors.toList());
    }
}