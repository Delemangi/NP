package k1.canvas2;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {
    private final List<Canvas> list;
    private final double maxArea;

    public ShapesApplication(double maxArea) {
        this.list = new ArrayList<Canvas>();
        this.maxArea = maxArea;
    }

    private void addCanvas(Canvas c) throws IrregularCanvasException {
        if (c.getMax() > maxArea) {
            throw new IrregularCanvasException(String.format("Canvas %s has a shape with area larger than %.2f", c.getID(), maxArea));
        }
        list.add(c);
    }

    public void readCanvases(InputStream in) {
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine()) {
            try {
                addCanvas(new Canvas(scanner.nextLine()));
            } catch (IrregularCanvasException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printCanvases(PrintStream out) {
        list.sort(Collections.reverseOrder());

        list.forEach(out::println);
    }
}