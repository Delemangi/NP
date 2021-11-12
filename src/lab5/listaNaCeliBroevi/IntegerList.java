package lab5.listaNaCeliBroevi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerList {
    private List<Integer> list;

    public IntegerList() {
        this.list = new ArrayList<>();
    }

    public IntegerList(Integer... numbers) {
        this.list = new ArrayList<>();
        IntStream.range(0, numbers.length).forEach(i -> list.add(numbers[i]));
    }

    public void add(int e, int i) {
        if (i >= list.size()) {
            IntStream.range(list.size(), i).forEach(x -> list.add(x, 0));
        }

        list.add(i, e);
    }

    public int remove(int i) {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list.remove(i);
    }

    public void set(int e, int i) {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list.set(i, e);
    }

    public int get(int i) {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public int count(int e) {
        return (int) list.stream().filter(i -> i == e).count();
    }

    public void removeDuplicates() {
        Collections.reverse(list);
        list = list.stream().distinct().collect(Collectors.toList());
        Collections.reverse(list);
    }

    public int sumFirst(int k) {
        return list.stream().limit(k).mapToInt(i -> i).sum();
    }

    public int sumLast(int k) {
        return list.stream().skip((long) list.size() - k).mapToInt(i -> i).sum();
    }

    public void shiftRight(int i, int k) {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int a = list.get(i);

        list.remove(i);

        list.add((i + k) % (list.size() + 1), a);
    }

    public void shiftLeft(int i, int k) {
        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int a = list.get(i);

        list.remove(i);

        list.add(Math.floorMod(i - k, list.size() + 1), a);
    }

    public IntegerList addValue(int a) {
        IntegerList il = new IntegerList();

        il.list = list.stream().map(i -> i + a).collect(Collectors.toList());

        return il;
    }
}