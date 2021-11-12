package lab5.kompleksniBroevi;

public class ComplexNumber<R extends Number, I extends Number> implements Comparable<ComplexNumber<?, ?>> {
    private final R real;
    private final I imaginary;

    public ComplexNumber(R real, I imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public R getReal() {
        return real;
    }

    public I getImaginary() {
        return imaginary;
    }

    public double modul() {
        return Math.sqrt(Math.pow(real.doubleValue(), 2) + Math.pow(imaginary.doubleValue(), 2));
    }

    @Override
    public int compareTo(ComplexNumber<?, ?> o) {
        return Double.compare(modul(), o.modul());
    }

    @Override
    public String toString() {
        return String.format("%.2f%+.2fi", real.doubleValue(), imaginary.doubleValue());
    }
}