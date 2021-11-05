package k1.f1Trka;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class F1Race {
    private final List<Pilot> pilots;

    public F1Race() {
        pilots = new ArrayList<Pilot>();
    }

    public void readResults(InputStream in) {
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine()) {
            Pilot p = new Pilot(scanner.nextLine());
            pilots.add(p);
        }
    }

    public void printSorted(PrintStream out) {
        Collections.sort(pilots);

        for (int i = 0; i < pilots.size(); i++) {
            out.printf("%d. %s%n", i + 1, pilots.get(i).toString());
        }
    }
}