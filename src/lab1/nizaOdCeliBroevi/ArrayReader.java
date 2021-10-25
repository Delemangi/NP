package lab1.nizaOdCeliBroevi;

import java.io.InputStream;
import java.util.Scanner;

class ArrayReader {
    public static IntegerArray readIntegerArray(InputStream input) {
        Scanner scanner = new Scanner(input);

        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        return new IntegerArray(array);
    }
}