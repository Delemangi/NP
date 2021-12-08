package lab7.rasporeduvacSoMap;

import java.util.*;
import java.util.stream.Collectors;

public class Scheduler<T> {
    private final Map<Date, T> map;

    public Scheduler() {
        this.map = new HashMap<>();
    }

    public void add(Date d, T t) {
        map.put(d, t);
    }

    public boolean remove(Date d) {
        return map.remove(d) != null;
    }

    public T next() {
        Date date = new Date();

        return map.get(map.keySet().stream().filter(t -> t.after(date)).min(Date::compareTo).orElse(null));
    }

    public T last() {
        Date date = new Date();

        return map.get(map.keySet().stream().filter(t -> t.before(date)).max(Date::compareTo).orElse(null));
    }

    public ArrayList<T> getAll(Date begin, Date end) {
        return map.entrySet().stream().filter(i -> i.getKey().after(begin) && i.getKey().before(end)).map(Map.Entry::getValue).collect(Collectors.toCollection(ArrayList::new));
    }

    public T getFirst() {
        return map.get(map.keySet().stream().min(Date::compareTo).orElse(null));
    }

    public T getLast() {
        return map.get(map.keySet().stream().max(Date::compareTo).orElse(null));
    }
}