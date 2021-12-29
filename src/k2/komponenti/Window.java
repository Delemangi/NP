package k2.komponenti;

import java.util.*;

public class Window {
    private final String name;
    private final Map<Integer, Component> map;

    public Window(String name) {
        this.name = name;
        this.map = new TreeMap<>();
    }

    public void addComponent(int position, Component component) throws InvalidPositionException {
        if (map.containsKey(position)) {
            throw new InvalidPositionException(position);
        }

        map.put(position, component);
    }

    public void changeColor(int weight, String color) {
        for (Component component : map.values()) {
            changeColorRecursive(weight, color, component);
        }
    }

    private void changeColorRecursive(int weight, String color, Component component) {
        if (component.getWeight() < weight) {
            component.setColor(color);
        }

        for (Component c : component.getSet()) {
            changeColorRecursive(weight, color, c);
        }
    }

    public void swichComponents(int a, int b) {
        Component c1 = map.get(a);
        Component c2 = map.get(b);

        map.put(a, c2);
        map.put(b, c1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("WINDOW ").append(name).append("\n");
        map.forEach((k, v) -> sb.append(String.format("%d:%s", k, buildString(v, 0))));

        return sb.toString();
    }

    private String buildString(Component component, int level) {
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < level * 3; i++) {
            str.append("-");
        }

        sb.append(String.format("%s%s%n", str, component));

        for (Component c : component.getSet()) {
            sb.append(buildString(c, level + 1));
        }

        return sb.toString();
    }
}