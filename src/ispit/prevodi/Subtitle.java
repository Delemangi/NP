package ispit.prevodi;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

public class Subtitle {
    private final int id;
    private final String text;
    private LocalTime from;
    private LocalTime to;

    public Subtitle(int id, String text, String time) {
        this.id = id;
        this.text = text;

        String[] times = time.split("-->");
        String[] timeFrom = times[0].trim().split("[:,]");
        String[] timeTo = times[1].trim().split("[:,]");

        this.from = LocalTime.of(Integer.parseInt(timeFrom[0]), Integer.parseInt(timeFrom[1]), Integer.parseInt(timeFrom[2]), 1000000 * Integer.parseInt(timeFrom[3]));
        this.to = LocalTime.of(Integer.parseInt(timeTo[0]), Integer.parseInt(timeTo[1]), Integer.parseInt(timeTo[2]), 1000000 * Integer.parseInt(timeTo[3]));
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss,SSS");

        return String.format("%d%n%s --> %s%n%s%n", id, from.format(dtf), to.format(dtf), text);
    }

    public void shift(int time) {
        from = from.plus(time, ChronoUnit.MILLIS);
        to = to.plus(time, ChronoUnit.MILLIS);
    }

    public int getId() {
        return id;
    }
}