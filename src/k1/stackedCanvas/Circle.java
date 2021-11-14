package k1.stackedCanvas;

public class Circle extends Shape {
    private double radius;

    public Circle(String ID, Color color, double radius) {
        super(ID, color, Type.CIRCLE);
        this.radius = radius;
    }

    @Override
    public void scale(double f) {
        radius *= f;
    }

    @Override
    public double weight() {
        return Math.PI * radius * radius;
    }
}