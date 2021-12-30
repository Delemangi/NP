package k2.onlajnProdavnica;

import java.time.*;

public class Product {
    private final String id;
    private final String name;
    private final LocalDateTime createdAt;
    private final double price;
    private int quantitySold;

    public Product(String id, String name, LocalDateTime createdAt, double price) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.price = price;
        this.quantitySold = 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", price=").append(price);
        sb.append(", quantitySold=").append(quantitySold);
        sb.append('}');
        return sb.toString();
    }

    public void increaseSold(int quantity) {
        quantitySold += quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantitySold() {
        return quantitySold;
    }
}