package ispit.generickiKlaster;

public class Point2D extends Clusterable<Point2D> {
    private final double x;
    private final double y;

    public Point2D(long ID, double x, double y) {
        this.ID = ID;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getDistance(Point2D e) {
        return Math.sqrt(Math.pow(x - e.getX(), 2) + Math.pow(y - e.getY(), 2));
    }

    public long getID() {
        return ID;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}