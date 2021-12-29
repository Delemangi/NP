package k2.unikatniIminja;

import java.util.*;

public class Names {
    private final Map<String, Integer> map;

    public Names() {
        this.map = new TreeMap<>();
    }

    public void addName(String name) {
        map.putIfAbsent(name, 0);
        map.compute(name, (k, v) -> v + 1);
    }

    public void printN(int n) {
        map.entrySet().stream().filter(i -> i.getValue() >= n).forEach(i -> System.out.printf("%s (%d) %d%n", i.getKey(), i.getValue(), uniqueLetters(i.getKey())));
    }

    private static int uniqueLetters(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toLowerCase().toCharArray()) {
            set.add(c);
        }

        return set.size();
    }

    public String findName(int len, int index) {
        Map<String, Integer> treeMap = new TreeMap<>();
        map.entrySet().stream().filter(i -> i.getKey().length() < len).forEach(i -> treeMap.put(i.getKey(), i.getValue()));

        int i = 0;
        for (String str : treeMap.keySet()) {
            if (index % treeMap.size() == i)
                return str;

            i++;
        }

        return null;
    }
}