package ispit.prevodi;

import java.io.*;
import java.util.*;

public class Subtitles {
    private final List<Subtitle> list;

    public Subtitles() {
        this.list = new ArrayList<>();
    }

    public int loadSubtitles(InputStream in) {
        Scanner scanner = new Scanner(in);

        while (scanner.hasNext()) {
            int id = scanner.nextInt();
            scanner.nextLine();
            String time = scanner.nextLine();
            List<String> strings = new ArrayList<>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (line.trim().length() == 0) {
                    break;
                }

                strings.add(line);
            }

            list.add(new Subtitle(id, String.join("\n", strings), time));
        }

        return list.size();
    }

    public void shift(int time) {
        list.forEach(s -> s.shift(time));
    }

    public void print() {
        list.forEach(System.out::println);
    }
}