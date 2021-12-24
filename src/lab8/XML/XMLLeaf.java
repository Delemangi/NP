package lab8.XML;

import java.util.*;
import java.util.stream.Collectors;

public class XMLLeaf implements XMLComponent {
    private final String tag;
    private final String value;
    private final Map<String, String> attributes;

    public XMLLeaf(String tag, String value) {
        this.tag = tag;
        this.value = value;
        this.attributes = new HashMap<>();
    }

    @Override
    public String getType() {
        return "LEAF";
    }

    @Override
    public void addAttribute(String attribute, String value) {
        attributes.putIfAbsent(attribute, value);
    }

    @Override
    public String toString() {
        return String.format("<%s%s%s>%s</%s>", tag, attributes.size() != 0 ? " " : "", attributes.entrySet().stream().map(i -> String.format("%s=\"%s\"", i.getKey(), i.getValue())).collect(Collectors.joining(" ")), value, tag);
    }
}