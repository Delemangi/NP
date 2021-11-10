package k1.mernaStanica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherStation {
    private final int n;
    private final List<Measurement> list;
    public static final long MS = 86400000;

    public WeatherStation(int n) {
        this.n = n;
        list = new ArrayList<Measurement>();
    }

    public void addMeasurement(float temp, float wind, float hum, float vis, Date date) {
        Measurement m = new Measurement(temp, wind, hum, vis, date);

        for (Measurement mea : list) {
            if (mea.compareTo(m) == 0) {
                return;
            }
        }

        list.removeIf(i -> m.getDate().getTime() - i.getDate().getTime() > n * MS);

        list.add(m);
    }

    public int total() {
        return list.size();
    }

    public void status(Date from, Date to) {
        List<Measurement> newList;

        newList = list.stream().filter(i -> (i.getDate().after(from) || i.getDate().equals(from)) && (i.getDate().before(to) || i.getDate().equals(to))).collect(Collectors.toList());

        if (newList.isEmpty()) {
            throw new RuntimeException();
        }

        double p = newList.stream().mapToDouble(Measurement::getTemperature).average().getAsDouble();

        for (Measurement m : newList) {
            System.out.println(m.toString());
        }

        System.out.printf("Average temperature: %.2f", p);
    }
}