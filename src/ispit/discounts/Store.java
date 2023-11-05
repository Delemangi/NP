package ispit.discounts;

import java.util.*;
import java.util.stream.*;

public class Store {
    private final String name;
    private final List<Product> products;

    public Store(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    @Override
    public String toString() {
        return String.format("%s%nAverage discount: %.1f%%%nTotal discount: %d%n%s",
                name,
                getAverageDiscount(),
                getTotalDiscount(),
                products
                        .stream()
                        .sorted()
                        .map(Product::toString)
                        .collect(Collectors.joining("\n")));
    }

    public double getAverageDiscount() {
        return products
                .stream()
                .mapToDouble(Product::getDiscountRelative)
                .average()
                .orElse(0);
    }

    public int getTotalDiscount() {
        return products
                .stream()
                .mapToInt(Product::getDiscountAbsolute)
                .sum();
    }

    public String getName() {
        return name;
    }
}