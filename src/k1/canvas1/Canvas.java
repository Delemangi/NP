package k1.canvas1;

import java.util.ArrayList;
import java.util.List;

public class Canvas implements Comparable<Canvas> {
    private final String ID;
    private final List<Integer> size;

    public Canvas(String str) {
        this.size = new ArrayList<Integer>();

        String[] split = str.split("\\s+");
        this.ID = split[0];

        for (int i = 1; i < split.length; i++) {
            size.add(Integer.parseInt(split[i]));
        }
    }

    public int getPerimeter() {
        int s = 0;

        for (Integer i : size) {
            s += 4 * i;
        }

        return s;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", ID, size.size(), getPerimeter());
    }

    @Override
    public int compareTo(Canvas o) {
        return getPerimeter() - o.getPerimeter();
    }
}