package lab1.sistemZaBankarskoRabotenje;

import java.util.Objects;

public class FlatAmountProvisionTransaction extends Transaction implements ToDouble {
    private final String flatProvision;

    public FlatAmountProvisionTransaction(long fromID, long toID, String amount, String flatProvision) {
        super(fromID, toID, "FlatAmount", amount);
        this.flatProvision = flatProvision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return flatProvision.equals(that.flatProvision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatProvision);
    }

    @Override
    public double getProvision() {
        return ToDouble.toDouble(flatProvision);
    }

    public String getFlatProvision() {
        return flatProvision;
    }
}
