package k1.canvas2;

public class Circle extends Shape {
    public Circle(int side) {
        super(TYPE.CIRCLE, side);
    }

    @Override
    public double getArea() {
        return Math.PI * side * side;
    }
}