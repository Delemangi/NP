package lab5.generickiKontejnerSoPromenlivaDolzina;

import java.util.Arrays;

public class ResizableArray<T> {
    private T[] array;
    private int size;

    public ResizableArray() {
        this.array = (T[]) new Object[1];
        this.size = 0;
    }

    public void addElement(T element) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[size] = element;
        size++;
    }

    public boolean removeElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);

                size--;
                array[size] = null;

                if (size < array.length / 2) {
                    array = Arrays.copyOf(array, array.length / 2);
                }

                return true;
            }
        }

        return false;
    }

    public boolean contains(T element) {
        return Arrays.stream(array).limit(size).anyMatch(i -> i.equals(element));
    }

    public Object[] toArray() {
        return array;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int count() {
        return size;
    }

    public T elementAt(int i) {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[i];
    }

    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
        T[] a = (T[]) Arrays.copyOf(src.toArray(), src.count());

        for (T t : a) {
            dest.addElement(t);
        }
    }
}