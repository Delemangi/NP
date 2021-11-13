package k1.minMax;

public class MinMax<T extends Comparable<T>> {
    private T min;
    private T max;
    private int updates;
    private int countMin;
    private int countMax;

    public MinMax() {
        this.updates = 0;
        this.countMin = 0;
        this.countMax = 0;
    }

    public void update(T element) {
        if (updates == 0) {
            max = element;
            min = element;
        }

        if (min.compareTo(element) > 0) {
            min = element;
            countMin = 1;
        } else if (min.compareTo(element) == 0) {
            countMin++;
        }

        if (max.compareTo(element) < 0) {
            max = element;
            countMax = 1;
        } else if (max.compareTo(element) == 0) {
            countMax++;
        }

        updates++;
    }

    public T max() {
        return max;
    }

    public T min() {
        return min;
    }

    @Override
    public String toString() {
        return min + " " + max + " " + (updates - countMin - countMax) + "\n";
    }
}