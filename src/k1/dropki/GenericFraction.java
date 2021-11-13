package k1.dropki;

public class GenericFraction<N extends Number, D extends Number> {
    private final N numerator;
    private final D denominator;

    public GenericFraction(N numerator, D denominator) throws ZeroDenominatorException {
        if (denominator.doubleValue() == 0) {
            throw new ZeroDenominatorException();
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public GenericFraction<Double, Double> add(GenericFraction<? extends Number, ? extends Number> gf) throws ZeroDenominatorException {
        return new GenericFraction<>(numerator.doubleValue() * gf.denominator.doubleValue() + gf.numerator.doubleValue() * denominator.doubleValue(), denominator.doubleValue() * gf.denominator.doubleValue());
    }

    public double toDouble() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        int a = gcd(numerator.intValue(), denominator.intValue());

        return String.format("%.2f / %.2f", numerator.doubleValue() / a, denominator.doubleValue() / a);
    }
}