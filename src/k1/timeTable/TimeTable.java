package k1.timeTable;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TimeTable {
    private final List<String> list;

    public TimeTable() {
        this.list = new ArrayList<>();
    }

    public void readTimes(InputStream in) throws UnsupportedFormatException, InvalidTimeException {
        Scanner scanner = new Scanner(in);
        String[] split;

        while (scanner.hasNextLine()) {
            split = scanner.nextLine().split("\\s+");

            for (String str : split) {
                if (!isValidFormat(str)) {
                    throw new UnsupportedFormatException(str);
                }

                if (!isValidTime(str)) {
                    throw new InvalidTimeException(str);
                }

                list.add(str.replace(".", ":"));
            }
        }
    }

    public void writeTimes(OutputStream out, TimeFormat tf) {
        PrintWriter pw = new PrintWriter(out);

        if (tf == TimeFormat.FORMAT_24) {
            list.stream().sorted(Comparator.comparing(TimeTable::getTime)).forEach(i -> pw.printf("%5s%n", i));
        } else {
            list.stream().sorted(Comparator.comparing(TimeTable::getTime)).forEach(i -> pw.printf("%8s%n", toAMPM(i)));
        }

        pw.flush();
    }

    private boolean isValidFormat(String str) {
        return str.matches("\\d+[:.]\\d+");
    }

    private boolean isValidTime(String str) {
        return str.matches("([0-9]|1[0-9]|2[0-3])[:.][0-5][0-9]");
    }

    public static String toAMPM(String str) {
        if (str.matches("0:[0-5][0-9]")) {
            return str.replace("0:", "12:") + " AM";
        } else if (str.matches("([1-9]|1[01]):[0-5][0-9]")) {
            return str + " AM";
        } else if (str.matches("12:[0-5][0-9]")) {
            return str + " PM";
        } else {
            return String.format("%d:%s PM", Integer.parseInt(str.substring(0, 2)) - 12, str.substring(3, 5));
        }
    }

    public static int getTime(String str) {
        return Integer.parseInt(str.split(":")[0]) * 60 + Integer.parseInt(str.split(":")[1]);
    }
}