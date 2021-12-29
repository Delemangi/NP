package k2.Stadium;

import java.util.*;

public class Sector {
    private final String code;
    private final int seats;
    private final Map<Integer, Boolean> map;
    private int type;

    public Sector(String code, int seats) {
        this.code = code;
        this.seats = seats;
        this.map = new HashMap<>();
        this.type = 0;
    }

    public Map<Integer, Boolean> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d/%d\t%.1f%%", code, seats - map.size(), seats, ((double) map.size() / seats) * 100.0);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFreeSeats() {
        return seats - map.size();
    }

    public String getCode() {
        return code;
    }
}