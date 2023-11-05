package ispit.discounts;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Discounts {
    private final List<Store> stores;

    public Discounts() {
        this.stores = new ArrayList<>();
    }

    public int readStores(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        br.lines().forEach(line -> {
            String[] tokens = line.split("\\s+");
            List<Product> products = new ArrayList<>();

            for (int i = 1; i < tokens.length; i++) {
                String[] prices = tokens[i].split(":");
                products.add(new Product(Integer.parseInt(prices[0]), Integer.parseInt(prices[1])));
            }

            stores.add(new Store(tokens[0], products));
        });

        return stores.size();
    }

    public List<Store> byAverageDiscount() {
        return stores
                .stream()
                .sorted(Comparator
                        .comparing(Store::getAverageDiscount)
                        .reversed()
                        .thenComparing(Store::getName))
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Store> byTotalDiscount() {
        return stores
                .stream()
                .sorted(Comparator
                        .comparing(Store::getTotalDiscount)
                        .thenComparing(Store::getName))
                .limit(3)
                .collect(Collectors.toList());
    }
}