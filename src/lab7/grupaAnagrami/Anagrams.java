package lab7.grupaAnagrami;

import java.io.*;
import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        findAll(System.in);
    }

    public static void findAll(InputStream input) {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        Map<String, List<String>> map = new TreeMap<>();

        br.lines().forEach(line -> {
            String key = map.keySet().stream().filter(i -> isAnagram(line, i)).findFirst().orElse(null);

            if (key == null) {
                List<String> list = new ArrayList<>();
                list.add(line);
                map.put(line, list);
            } else {
                map.get(key).add(line);
            }
        });

        print(map);
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        return Arrays.equals(char1, char2);
    }

    public static void print(Map<String, List<String>> map) {
        map.values().stream().filter(i -> i.size() >= 5).forEach(i -> System.out.println(String.join(" ", i)));
    }
}