package k2.kalendarNaNastani;

import java.text.*;
import java.util.*;

public class Event implements Comparable<Event> {
    private final String name;
    private final String location;
    private final Date date;

    public Event(String name, String location, Date date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public static int getKey(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    @Override
    public int compareTo(Event o) {
        int compare = date.compareTo(o.date);

        return compare == 0 ? name.compareTo(o.name) : compare;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd MMM, yyyy HH:mm");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        return String.format("%s at %s, %s", df.format(date), location, name);
    }
}