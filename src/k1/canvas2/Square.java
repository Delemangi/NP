package k1.canvas2;

public class Square extends Shape {
    public Square(int side) {
        super(TYPE.SQUARE, side);
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
