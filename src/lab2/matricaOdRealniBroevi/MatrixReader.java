package lab2.matricaOdRealniBroevi;

import java.io.InputStream;
import java.util.Scanner;

public class MatrixReader {
    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner scanner = new Scanner(input);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        double[] array = new double[m * n];

        for (int i = 0; i < m * n; i++) {
            array[i] = scanner.nextDouble();
        }

        return new DoubleMatrix(array, m, n);
    }
}