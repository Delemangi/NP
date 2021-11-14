package k1.dnevniTemperaturi;

import java.util.ArrayList;
import java.util.List;

public class Measurement implements Comparable<Measurement> {
    private final int day;
    private final List<Temperature> list;

    private Measurement(int day, List<Temperature> list) {
        this.day = day;
        this.list = list;
    }

    public static Measurement newMeasurement(String str) {
        String[] split = str.split("\\s+");
        List<Temperature> list = new ArrayList<>();

        int day = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (split[i].matches("-?\\d+C")) {
                list.add(new Temperature(Double.parseDouble(split[i].substring(0, split[i].length() - 1)), TYPE.C));
            } else {
                list.add(new Temperature(Double.parseDouble(split[i].substring(0, split[i].length() - 1)), TYPE.F));
            }
        }

        return new Measurement(day, list);
    }

    @Override
    public int compareTo(Measurement o) {
        return Integer.compare(day, o.day);
    }

    public String toString(char c) {
        double min;
        double max;
        double avg;

        if (c == 'C') {
            min = list.stream().min(Temperature::compareTo).get().toC();
            max = list.stream().max(Temperature::compareTo).get().toC();
            avg = list.stream().mapToDouble(Temperature::toC).average().getAsDouble();

            return String.format("%3d: Count: %3d Min: %6.2fC Max: %6.2fC Avg: %6.2fC", day, list.size(), min, max, avg);
        } else {
            min = list.stream().min(Temperature::compareTo).get().toF();
            max = list.stream().max(Temperature::compareTo).get().toF();
            avg = list.stream().mapToDouble(Temperature::toF).average().getAsDouble();

            return String.format("%3d: Count: %3d Min: %6.2fF Max: %6.2fF Avg: %6.2fF", day, list.size(), min, max, avg);
        }
    }
}