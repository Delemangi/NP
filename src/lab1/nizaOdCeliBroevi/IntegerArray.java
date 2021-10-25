package lab1.nizaOdCeliBroevi;

import java.util.Arrays;

public final class IntegerArray {
    private final int[] array;

    public IntegerArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public int length() {
        return this.array.length;
    }

    public int getElementAt(int i) {
        return this.array[i];
    }

    public int sum() {
        return Arrays.stream(array).sum();
    }

    public double average() {
        return (double) sum() / length();
    }

    public IntegerArray getSorted() {
        return new IntegerArray(Arrays.stream(array).sorted().toArray());
    }

    public IntegerArray concat(IntegerArray ia) {
        int[] newArray = new int[length() + ia.length()];

        System.arraycopy(array, 0, newArray, 0, length());
        System.arraycopy(ia.array, 0, newArray, length(), ia.length());

        return new IntegerArray(newArray);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < length() - 1; i++) {
            sb.append(array[i]).append(", ");
        }

        sb.append(array[length() - 1]).append("]");

        return sb.toString();
    }
}