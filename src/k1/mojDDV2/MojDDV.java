package k1.mojDDV2;

import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MojDDV {
    private List<Receipt> list;

    public MojDDV() {
        this.list = new ArrayList<>();
    }

    public void readRecords(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        list = br.lines().map(Receipt::create).collect(Collectors.toList());
    }

    public void printTaxReturns(PrintStream out) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        for (Receipt r : list) {
            if (r != null) {
                pw.println(r);
            }
        }

        pw.flush();
    }

    public void printStatistics(PrintStream out) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        DoubleSummaryStatistics dss = list.stream().filter(Objects::nonNull).mapToDouble(Receipt::totalTaxReturn).summaryStatistics();

        pw.printf("min:\t%5.3f%nmax:\t%5.3f%nsum:\t%5.3f%ncount:\t%-5d%navg:\t%5.3f%n", dss.getMin(), dss.getMax(), dss.getSum(), dss.getCount(), dss.getAverage());

        pw.flush();
    }
}