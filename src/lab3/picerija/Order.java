package lab3.picerija;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> list;
    private boolean locked;

    public Order() {
        this.list = new ArrayList<>();
        this.locked = false;
    }

    public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
        if (count > 10) {
            throw new ItemOutOfStockException(count);
        }

        if (locked) {
            throw new OrderLockedException();
        }

        for (Product p : list) {
            if (p.getItem().equals(item)) {
                p.setCount(count);
                return;
            }
        }

        list.add(new Product(item, count));
    }

    public void removeItem(int i) throws OrderLockedException {
        if (locked) {
            throw new OrderLockedException();
        }

        if (i < 0 || i >= list.size()) {
            throw new ArrayIndexOutOfBoundsException(i);
        }

        list.remove(i);
    }

    public void lock() throws EmptyOrder {
        if (list.size() == 0) {
            throw new EmptyOrder();
        } else {
            locked = true;
        }
    }

    public void displayOrder() {
        StringBuilder sb = new StringBuilder();

        list.stream().forEach(i -> sb.append(String.format("%3d.%-15sx%2d%5d$%n", list.indexOf(i) + 1, i.getItem().getType(), i.getCount(), i.getItem().getPrice() * i.getCount())));
        sb.append(String.format("%-22s%5d$", "Total:", getPrice()));

        System.out.println(sb.toString());
    }

    public int getPrice() {
        return list.stream().mapToInt(i -> i.getItem().getPrice() * i.getCount()).sum();
    }
}