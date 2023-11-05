package ispit.discounts;

import java.util.*;

public class Product implements Comparable<Product> {
    private final int discountedPrice;
    private final int price;

    public Product(int discountedPrice, int price) {
        this.discountedPrice = discountedPrice;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%2d%% %d/%d", getDiscountRelative(), getDiscountedPrice(), getPrice());
    }

    @Override
    public int compareTo(Product o) {
        return Comparator
                .comparing(Product::getDiscountRelative)
                .thenComparing(Product::getDiscountAbsolute)
                .reversed()
                .compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return discountedPrice == product.discountedPrice && price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountedPrice, price);
    }

    public int getDiscountRelative() {
        return 100 - (discountedPrice * 100 / price);
    }

    public int getDiscountAbsolute() {
        return price - discountedPrice;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public int getPrice() {
        return price;
    }
}