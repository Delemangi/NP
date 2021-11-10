package k1.f1Trka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pilot implements Comparable<Pilot> {
    private final String name;
    private final List<LapTime> times;

    public Pilot(String str) {
        times = new ArrayList<LapTime>();
        String[] split = str.split("\\s+");

        this.name = split[0];
        times.add(new LapTime(split[1]));
        times.add(new LapTime(split[2]));
        times.add(new LapTime(split[3]));
    }

    public LapTime getBestTime() {
        return Collections.min(times);
    }

    @Override
    public int compareTo(Pilot o) {
        return getBestTime().compareTo(o.getBestTime());
    }

    @Override
    public String toString() {
        return String.format("%-10s%10s", name, getBestTime().toString());
    }
}