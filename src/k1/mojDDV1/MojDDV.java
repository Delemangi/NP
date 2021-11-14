package k1.mojDDV1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
                pw.println(r.toString());
            }
        }

        pw.flush();
    }
}