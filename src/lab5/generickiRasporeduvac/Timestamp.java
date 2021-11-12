package lab5.generickiRasporeduvac;

import java.time.LocalDateTime;
import java.util.Objects;

public class Timestamp<T> implements Comparable<Timestamp<?>> {
    private final LocalDateTime time;
    private final T element;

    public Timestamp(LocalDateTime time, T element) {
        this.time = time;
        this.element = element;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public T getElement() {
        return element;
    }

    @Override
    public int compareTo(Timestamp<?> o) {
        return time.compareTo(o.time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp<?> timestamp = (Timestamp<?>) o;
        return time.equals(timestamp.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    @Override
    public String toString() {
        return time.toString() + " " + element.toString();
    }
}