package k1.stackedCanvas;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String ID, Color color, double width, double height) {
        super(ID, color, Type.RECTANGLE);
        this.width = width;
        this.height = height;
    }

    @Override
    public void scale(double f) {
        width *= f;
        height *= f;
    }

    @Override
    public double weight() {
        return width * height;
    }
}