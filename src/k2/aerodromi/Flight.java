package k2.aerodromi;

import java.util.*;

public class Flight implements Comparable<Flight> {
    private final String from;
    private final String to;
    private final int time;
    private final int duration;

    public Flight(String from, String to, int time, int duration) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.duration = duration;
    }

    public String getTo() {
        return to;
    }

    public int getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public int compareTo(Flight o) {
        return Comparator.comparing(Flight::getTo).thenComparing(Flight::getTime).thenComparing(Flight::getFrom).compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return time == flight.time && duration == flight.duration && from.equals(flight.from) && to.equals(flight.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, time, duration);
    }

    @Override
    public String toString() {
        int end = time + duration;

        return String.format("%s-%s %02d:%02d-%02d:%02d %s%dh%02dm", from, to, time / 60, time % 60, (end / 60) % 24, end % 60, (end / 60) / 24 > 0 ? "+1d " : "", duration / 60, duration % 60);
    }
}