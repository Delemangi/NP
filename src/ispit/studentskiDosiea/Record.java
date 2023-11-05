package ispit.studentskiDosiea;

import java.util.*;

public class Record implements Comparable<Record> {
    private final String id;
    private final String group;
    private final List<Integer> grades;

    public Record(String id, String group, List<Integer> grades) {
        this.id = id;
        this.group = group;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", id, average());
    }

    @Override
    public int compareTo(Record o) {
        return Comparator
                .comparing(Record::average)
                .reversed()
                .thenComparing(Record::getId)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id.equals(record.id) && group.equals(record.group) && grades.equals(record.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, grades);
    }

    public double average() {
        return grades
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }

    public String getId() {
        return id;
    }
}