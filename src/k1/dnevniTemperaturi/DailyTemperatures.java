package k1.dnevniTemperaturi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DailyTemperatures {
    private List<Measurement> list;

    public DailyTemperatures() {
        this.list = new ArrayList<>();
    }

    public void readTemperatures(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        list = br.lines().map(Measurement::newMeasurement).collect(Collectors.toList());
    }

    public void writeDailyStats(PrintStream out, char c) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        list.stream().sorted().forEach(i->pw.println(i.toString(c)));

        pw.flush();
    }
}