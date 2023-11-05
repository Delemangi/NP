package ispit.studentskiDosiea;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class StudentRecords {
    private final Map<String, Set<Record>> records;
    private final Map<String, List<Integer>> grades;

    public StudentRecords() {
        this.records = new HashMap<>();
        this.grades = new HashMap<>();
    }

    public int readRecords(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        AtomicInteger n = new AtomicInteger();

        br.lines().forEach(line -> {
            String[] tokens = line.split("\\s+");
            List<Integer> list = IntStream.range(2, tokens.length).mapToObj(i -> Integer.parseInt(tokens[i])).collect(Collectors.toList());

            Record record = new Record(tokens[0], tokens[1], list);

            records.putIfAbsent(tokens[1], new TreeSet<>());
            records.computeIfPresent(tokens[1], (k, v) -> {
                v.add(record);
                return v;
            });

            grades.putIfAbsent(tokens[1], new ArrayList<>());
            grades.computeIfPresent(tokens[1], (k, v) -> {
                v.addAll(list);
                return v;
            });

            n.getAndIncrement();
        });

        return n.get();
    }

    public void writeTable(PrintStream out) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        records.forEach((k, v) -> {
            pw.println(k);
            v.forEach(pw::println);
        });

        pw.flush();
    }

    public void writeDistribution(PrintStream out) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        Comparator<Map.Entry<String, List<Integer>>> comparator = (a, b) -> Long.compare(b.getValue().stream().filter(i -> i == 10).count(), a.getValue().stream().filter(i -> i == 10).count());

        grades
                .entrySet()
                .stream()
                .sorted(comparator)
                .forEach(entry -> {
                    pw.println(entry.getKey());

                    for (int i = 6; i < 11; i++) {
                        int finalI = i;
                        long n = entry.getValue().stream().filter(grade -> grade == finalI).count();

                        pw.printf("%2d | %s(%d)%n", i, asterisks(n), n);
                    }
                });

        pw.flush();
    }

    private String asterisks(long n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.ceil(n / 10.0); i++) {
            sb.append("*");
        }

        return sb.toString();
    }
}