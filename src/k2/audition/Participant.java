package k2.audition;

import java.util.Objects;

public class Participant implements Comparable<Participant> {
    private final String city;
    private final String code;
    private final String name;
    private final int age;

    public Participant(String city, String code, String name, int age) {
        this.city = city;
        this.code = code;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return city.equals(that.city) && code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, code);
    }

    @Override
    public int compareTo(Participant o) {
        int compare = name.compareTo(o.name);

        return compare == 0 ? Integer.compare(age, o.age) : compare;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", code, name, age);
    }

    public String getCity() {
        return city;
    }
}