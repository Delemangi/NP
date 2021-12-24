package lab8.XML;

import java.util.*;
import java.util.stream.Collectors;

public class XMLComposite implements XMLComponent {
    private final String tag;
    private final Map<String, String> attributes;
    private final List<XMLComponent> components;

    public XMLComposite(String tag) {
        this.tag = tag;
        this.attributes = new HashMap<>();
        this.components = new ArrayList<>();
    }

    @Override
    public String getType() {
        return "COMPOSITE";
    }

    @Override
    public void addAttribute(String attribute, String value) {
        attributes.putIfAbsent(attribute, value);
    }

    public void addComponent(XMLComponent component) {
        components.add(component);
    }

    private String toStringRecursive(XMLComposite xml, int level) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(String.format("<%s%s%s>%n", xml.tag, attributes.size() != 0 ? " " : "", xml.attributes.entrySet().stream().map(i -> String.format("%s=\"%s\"", i.getKey(), i.getValue())).collect(Collectors.joining(" "))));

        for (XMLComponent component : xml.components) {
            if (component.getType().equals("LEAF")) {
                for (int i = 0; i < level; i++) {
                    sb.append("\t");
                }
                sb.append(component).append("\n");
            } else if (component.getType().equals("COMPOSITE")) {
                sb.append(toStringRecursive((XMLComposite) component, level + 1)).append("\n");
            }
        }

        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(String.format("</%s>", xml.tag));

        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringRecursive(this, 0);
    }
}