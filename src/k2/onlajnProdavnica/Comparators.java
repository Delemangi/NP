package k2.onlajnProdavnica;

import java.util.*;

public class Comparators {
    public static Comparator<Product> getComparator(COMPARATOR_TYPE comparatorType) {
        switch (comparatorType) {
            case NEWEST_FIRST:
                return Comparator.comparing(Product::getCreatedAt).reversed();
            case OLDEST_FIRST:
                return Comparator.comparing(Product::getCreatedAt);
            case LOWEST_PRICE_FIRST:
                return Comparator.comparing(Product::getPrice);
            case HIGHEST_PRICE_FIRST:
                return Comparator.comparing(Product::getPrice).reversed();
            case MOST_SOLD_FIRST:
                return Comparator.comparing(Product::getQuantitySold).reversed();
            default:
                return Comparator.comparing(Product::getQuantitySold);
        }
    }
}