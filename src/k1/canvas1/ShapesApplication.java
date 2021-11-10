package k1.canvas1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {
    private final List<Canvas> list;

    public ShapesApplication() {
        this.list = new ArrayList<Canvas>();
    }

    public int readCanvases(InputStream in) {
        Scanner scanner = new Scanner(in);
        String str;
        int s = 0;

        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            s += str.split("\\s+").length - 1;
            list.add(new Canvas(str));
        }

        return s;
    }

    public void printLargestCanvasTo(PrintStream out) {
        System.out.println(list.stream().max(Canvas::compareTo).get());
    }
}