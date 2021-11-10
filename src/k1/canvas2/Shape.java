package k1.canvas2;

public abstract class Shape implements Comparable<Shape> {
    protected TYPE type;
    protected int side;

    protected Shape(TYPE type, int side) {
        this.type = type;
        this.side = side;
    }

    public TYPE getType() {
        return type;
    }

    public abstract double getArea();

    @Override
    public int compareTo(Shape o) {
        return Double.compare(getArea(), o.getArea());
    }
}