package k2.aerodromi;

import java.util.*;
import java.util.stream.Collectors;

public class Airports {
    private final Map<String, Airport> airports;
    private final Map<String, Set<Flight>> fromFlights;
    private final Map<String, Set<Flight>> toFlights;

    public Airports() {
        this.airports = new HashMap<>();
        this.fromFlights = new HashMap<>();
        this.toFlights = new HashMap<>();
    }

    public void addAirport(String name, String country, String code, int passengers) {
        airports.put(code, new Airport(name, country, code, passengers));
    }

    public void addFlights(String from, String to, int time, int duration) {
        Flight flight = new Flight(from, to, time, duration);

        fromFlights.putIfAbsent(from, new TreeSet<>());
        toFlights.putIfAbsent(to, new TreeSet<>());

        fromFlights.get(from).add(flight);
        toFlights.get(to).add(flight);
    }

    public void showFlightsFromAirport(String from) {
        System.out.println(airports.get(from));

        Set<Flight> set = fromFlights.get(from);
        int i = 1;

        for (Flight flight : set) {
            System.out.printf("%d. %s%n", i++, flight);
        }
    }

    public void showDirectFlightsFromTo(String from, String to) {
        Set<Flight> set = fromFlights.get(from).stream().filter(i -> i.getTo().equals(to)).collect(Collectors.toSet());

        if (!set.isEmpty()) {
            set.forEach(System.out::println);
        } else {
            System.out.printf("No flights from %s to %s%n", from, to);
        }
    }

    public void showDirectFlightsTo(String to) {
        toFlights.get(to).forEach(System.out::println);
    }
}