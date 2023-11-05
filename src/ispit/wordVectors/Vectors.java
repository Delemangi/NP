package ispit.wordVectors;

import java.util.*;
import java.util.stream.*;

public class Vectors {
    private List<Integer> vector;
    protected static final List<Integer> NEUTRAL = Arrays.asList(5, 5, 5, 5, 5);
    protected static final List<Integer> DEFAULT = Arrays.asList(0, 0, 0, 0, 0);

    public Vectors(List<Integer> vector) {
        this.vector = vector;
    }

    public Vectors sum(Vectors o) {
        return new Vectors(IntStream
                .range(0, 5)
                .map(i -> vector.get(i) + o.vector.get(i))
                .boxed()
                .collect(Collectors.toList())
        );
    }

    public int max() {
        return vector
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}