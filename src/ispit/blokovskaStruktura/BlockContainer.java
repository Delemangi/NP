package ispit.blokovskaStruktura;

import java.util.*;
import java.util.stream.Collectors;

public class BlockContainer<T extends Comparable<T>> {
    private final int size;
    private List<Set<T>> blocks;

    public BlockContainer(int size) {
        this.size = size;
        this.blocks = new ArrayList<>();
    }

    public void add(T e) {
        if (blocks.isEmpty()) {
            Set<T> set = new TreeSet<>();
            set.add(e);
            blocks.add(set);
        } else {
            Set<T> set = blocks.get(blocks.size() - 1);

            if (set.size() < size) {
                set.add(e);
            } else {
                set = new TreeSet<>();

                set.add(e);
                blocks.add(set);
            }
        }
    }

    public boolean remove(T e) {
        boolean flag = false;

        if (!blocks.isEmpty()) {
            Set<T> set = blocks.get(blocks.size() - 1);
            flag = set.remove(e);

            if (set.isEmpty()) {
                blocks.remove(blocks.size() - 1);
            }
        }

        return flag;
    }

    public void sort() {
        List<T> list = new ArrayList<>();
        blocks.forEach(list::addAll);
        list.sort(Comparator.naturalOrder());

        blocks = new ArrayList<>(list
                .stream()
                .collect(Collectors.groupingBy(i -> list.indexOf(i) / size, Collectors.toCollection(TreeSet::new)))
                .values());
    }

    @Override
    public String toString() {
        List<String> strings = new ArrayList<>();

        blocks.forEach(s -> strings.add(s.toString()));

        return String.join(",", strings);
    }
}