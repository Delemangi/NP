package k2.komponenti;

import java.util.*;

public class Component implements Comparable<Component> {
    private String color;
    private final int weight;
    private final Set<Component> set;

    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        this.set = new TreeSet<>();
    }

    public void addComponent(Component component) {
        set.add(component);
    }

    @Override
    public int compareTo(Component o) {
        int compare = weight - o.weight;

        return compare != 0 ? compare : color.compareTo(o.color);
    }

    public int getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Component> getSet() {
        return set;
    }

    @Override
    public String toString() {
        return String.format("%d:%s", weight, color);
    }
}