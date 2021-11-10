package k1.canvas2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Canvas implements Comparable<Canvas> {
    private final String ID;
    private final List<Shape> list;

    public Canvas(String str) {
        this.list = new ArrayList<Shape>();

        String[] split = str.split("\\s+");
        this.ID = split[0];

        for (int i = 1; i < split.length; i += 2) {
            if (split[i].equals("C")) {
                list.add(new Circle(Integer.parseInt(split[i + 1])));
            } else if (split[i].equals("S")) {
                list.add(new Square(Integer.parseInt(split[i + 1])));
            }
        }
    }

    public double getMax() {
        return Collections.max(list).getArea();
    }

    public double getMin() {
        return Collections.min(list).getArea();
    }

    public double getArea() {
        return list.stream().mapToDouble(Shape::getArea).sum();
    }

    public double averageArea() {
        return list.stream().mapToDouble(Shape::getArea).average().getAsDouble();
    }

    public long totalCircles() {
        return list.stream().filter(i -> i.getType().equals(TYPE.CIRCLE)).count();
    }

    public long totalSquares() {
        return list.stream().filter(i -> i.getType().equals(TYPE.SQUARE)).count();
    }

    public String getID() {
        return ID;
    }

    @Override
    public int compareTo(Canvas o) {
        return Double.compare(getArea(), o.getArea());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %.2f %.2f %.2f", ID, list.size(), totalCircles(), totalSquares(), getMin(), getMax(), averageArea());
    }
}