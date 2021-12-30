package k2.onlajnProdavnica;

import java.util.*;
import java.util.stream.*;
import java.time.*;

public class OnlineShop {
    private final Map<String, Product> products;
    private final Map<String, List<Product>> categories;

    public OnlineShop() {
        this.products = new HashMap<>();
        this.categories = new HashMap<>();
    }

    public void addProduct(String category, String id, String name, LocalDateTime createdAt, double price) {
        Product product = new Product(id, name, createdAt, price);

        products.put(id, product);
        categories.putIfAbsent(category, new ArrayList<>());
        categories.computeIfPresent(category, (k, v) -> {
            v.add(product);
            return v;
        });
    }

    public double buyProduct(String id, int quantity) throws ProductNotFoundException {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException(id);
        }

        Product product = products.get(id);
        product.increaseSold(quantity);

        return quantity * product.getPrice();
    }

    public List<List<Product>> listProducts(String category, COMPARATOR_TYPE comparatorType, int pageSize) {
        List<Product> list = category != null ? categories.get(category) : new ArrayList<>(products.values());
        list.sort(Comparators.getComparator(comparatorType));

        return new ArrayList<>(list.stream().collect(Collectors.groupingBy(i -> list.indexOf(i) / pageSize)).values());
    }
}