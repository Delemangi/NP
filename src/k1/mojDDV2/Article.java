package k1.mojDDV2;

public class Article {
    private final int amount;
    private final String type;

    public Article(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getTax() {
        if (type.equals("A")) {
            return amount * 0.18;
        } else if (type.equals("B")) {
            return amount * 0.05;
        } else {
            return 0;
        }
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}