package k2.kalendarNaNastani;

import java.text.*;
import java.util.*;
import java.util.stream.IntStream;

public class EventCalendar {
    private final int year;
    private final HashMap<Integer, TreeSet<Event>> events;
    private final HashMap<Integer, Integer> eventsCount;

    public EventCalendar(int year) {
        this.year = year;
        this.events = new HashMap<>();
        this.eventsCount = new HashMap<>();

        IntStream.range(1, 13).forEach(i -> eventsCount.put(i, 0));
    }

    public void addEvent(String name, String location, Date date) throws WrongDateException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (calendar.get(Calendar.YEAR) != year) {
            DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyy");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));

            throw new WrongDateException(df.format(date));
        }

        Event event = new Event(name, location, date);
        int key = Event.getKey(date);

        TreeSet<Event> eventsValue = events.computeIfAbsent(key, k -> new TreeSet<>());
        eventsValue.add(event);
        eventsCount.computeIfPresent(calendar.get(Calendar.MONTH) + 1, (k, v) -> v + 1);
    }

    public void listEvents(Date date) {
        TreeSet<Event> eventsValue = events.get(Event.getKey(date));

        if (eventsValue != null) {
            eventsValue.forEach(System.out::println);
        } else {
            System.out.println("No events on this day!");
        }
    }

    public void listByMonth() {
        eventsCount.forEach((k, v) -> System.out.printf("%d : %d%n", k, v));
    }
}