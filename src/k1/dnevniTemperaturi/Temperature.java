package k1.dnevniTemperaturi;

public class Temperature implements Comparable<Temperature> {
    private final double value;
    private final TYPE type;

    public Temperature(double value, TYPE type) {
        this.value = value;
        this.type = type;
    }

    public double toC() {
        if (type == TYPE.C) {
            return value;
        } else {
            return (value - 32) * 5.0 / 9.0;
        }
    }

    public double toF() {
        if (type == TYPE.F) {
            return value;
        } else {
            return value * 9.0 / 5.0 + 32;
        }
    }

    @Override
    public int compareTo(Temperature o) {
        return Double.compare(toC(), o.toC());
    }
}