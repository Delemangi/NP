package k1.stackedCanvas;

public abstract class Shape implements Scalable, Stackable, Comparable<Shape> {
    private String ID;
    private Color color;
    private Type type;

    protected Shape(String ID, Color color, Type type) {
        this.ID = ID;
        this.color = color;
        this.type = type;
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(weight(), o.weight());
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return String.format("%s: %-5s%-10s%10.2f%n", type == Type.RECTANGLE ? "R" : "C", ID, color.toString(), weight());
    }
}
