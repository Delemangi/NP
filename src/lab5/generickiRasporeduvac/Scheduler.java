package lab5.generickiRasporeduvac;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler<T> {
    private List<Timestamp<T>> list;
    private T element;

    public Scheduler() {
        this.list = new ArrayList<>();
    }

    public void add(Timestamp<T> t) {
        list.add(t);
    }

    public boolean remove(Timestamp<T> t) {
        return list.removeIf(i -> i.equals(t));
    }

    public Timestamp<T> next() {
        return list.stream().filter(i -> i.getTime().isAfter(LocalDateTime.now())).min(Timestamp::compareTo).get();
    }

    public Timestamp<T> last() {
        return list.stream().filter(i -> i.getTime().isBefore(LocalDateTime.now())).max(Timestamp::compareTo).get();
    }

    public List<Timestamp<T>> getAll(LocalDateTime ldt1, LocalDateTime ldt2) {
        return list.stream().filter(i -> i.getTime().isAfter(ldt1) && i.getTime().isBefore(ldt2)).collect(Collectors.toList());
    }
}