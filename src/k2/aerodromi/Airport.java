package k2.aerodromi;

public class Airport {
    private final String name;
    private final String country;
    private final String code;
    private final int passengers;

    public Airport(String name, String country, String code, int passengers) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)%n%s%n%d", name, code, country, passengers);
    }
}