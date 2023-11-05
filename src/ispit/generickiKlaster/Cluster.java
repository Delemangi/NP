package ispit.generickiKlaster;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Cluster<T extends Clusterable<T>> {
    private final Map<Long, T> elements;

    public Cluster() {
        this.elements = new HashMap<>();
    }

    public void addItem(T e) {
        elements.put(e.getID(), e);
    }

    public void near(long ID, int top) {
        T e = elements.get(ID);
        Set<T> set = new TreeSet<>(Comparator.comparingDouble(a -> a.getDistance(e)));
        set.addAll(elements.values());
        set.remove(e);

        AtomicInteger i = new AtomicInteger(1);
        set.stream().limit(top).forEach(element -> System.out.printf("%d. %d -> %.3f%n", i.getAndIncrement(), element.getID(), element.getDistance(e)));
    }
}