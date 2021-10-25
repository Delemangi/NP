package lab1.sistemZaBankarskoRabotenje;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction implements ToDouble {
    private final int centsPerDollar;

    public FlatPercentProvisionTransaction(long fromID, long toID, String amount, int centsPerDollar) {
        super(fromID, toID, "FlatPercent", amount);
        this.centsPerDollar = centsPerDollar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return centsPerDollar == that.centsPerDollar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(centsPerDollar);
    }

    @Override
    public double getProvision() {
        return (int) ToDouble.toDouble(getAmount()) * (centsPerDollar / 100.0);
    }

    public int getCentsPerDollar() {
        return centsPerDollar;
    }
}
