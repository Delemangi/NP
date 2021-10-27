package lab2.matricaOdRealniBroevi;

import java.util.Arrays;
import java.util.Objects;

public final class DoubleMatrix {
    private double[][] matrix;
    private final int m;
    private final int n;

    DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException {
        this.m = m;
        this.n = n;

        if (a.length < m * n) {
            throw new InsufficientElementsException("Insufficient number of elements");
        } else if (a.length == m * n) {
            matrix = new double[m][n];
            int c = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.matrix[i][j] = a[c];
                    c++;
                }
            }
        } else {
            matrix = new double[m][n];
            int c = a.length - m * n;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.matrix[i][j] = a[c];
                    c++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(String.format("%.2f", matrix[i][j]));

                if (j != n - 1) {
                    sb.append("\t");
                }
            }

            if (i != m - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return m == that.m && n == that.n && Arrays.deepEquals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m, n);
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        if (row < 1 || row > m) {
            throw new InvalidRowNumberException("Invalid row number");
        }

        return Arrays.stream(matrix[row - 1]).max().getAsDouble();
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
        if (column < 1 || column > n) {
            throw new InvalidColumnNumberException("Invalid column number");
        }

        double[] col = new double[m];

        for (int i = 0; i < m; i++) {
            col[i] = matrix[i][column - 1];
        }

        return Arrays.stream(col).max().getAsDouble();
    }

    public double sum() {
        double s = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s += matrix[i][j];
            }
        }

        return s;
    }

    public double[] toSortedArray() {
        double[] array = new double[m * n];
        int c = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[c] = matrix[i][j];
                c++;
            }
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length / 2; i++) {
            double temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return array;
    }

    public String getDimensions() {
        return String.format("[%d x %d]", m, n);
    }

    public int rows() {
        return m;
    }

    public int columns() {
        return n;
    }
}