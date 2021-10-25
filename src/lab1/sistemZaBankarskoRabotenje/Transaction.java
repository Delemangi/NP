package lab1.sistemZaBankarskoRabotenje;

public abstract class Transaction {
    private final long fromID;
    private final long toID;
    private final String description;
    private final String amount;

    public Transaction(long fromID, long toID, String description, String amount) {
        this.fromID = fromID;
        this.toID = toID;
        this.description = description;
        this.amount = amount;
    }

    public abstract double getProvision();

    public long getFromId() {
        return fromID;
    }

    public long getToId() {
        return toID;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
