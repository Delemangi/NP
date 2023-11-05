package ispit.laboratoriskiVezbi;

import java.util.*;

public class Student {
    private final String index;
    private final List<Integer> points;

    public Student(String index, List<Integer> points) {
        this.index = index;
        this.points = points;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", index, isFailed() ? "NO" : "YES", getAveragePoints());
    }

    public double getAveragePoints() {
        return points
                .stream()
                .mapToDouble(Integer::intValue)
                .sum()
                / 10;
    }

    public int getYear() {
        return 20 - Integer.parseInt(index.substring(0, 2));
    }

    public boolean isFailed() {
        return points.size() < 8;
    }

    public String getIndex() {
        return index;
    }
}