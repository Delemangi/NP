package k1.stackedCanvas;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private final List<Shape> list;

    public Canvas() {
        this.list = new ArrayList<>();
    }

    public void add(String ID, Color color, double radius) {
        addToList(new Circle(ID, color, radius));
    }

    public void add(String ID, Color color, double width, double height) {
        addToList(new Rectangle(ID, color, width, height));
    }

    public void scale(String ID, double f) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(ID)) {
                Shape s = list.get(i);

                list.remove(s);
                s.scale(f);
                addToList(s);

                break;
            }
        }
    }

    public void addToList(Shape s) {
        if (list.isEmpty()) {
            list.add(s);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).weight() < s.weight()) {
                list.add(i, s);

                return;
            }
        }

        list.add(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Shape s : list) {
            sb.append(s.toString());
        }

        return sb.toString();
    }
}