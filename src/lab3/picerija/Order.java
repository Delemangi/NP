package lab3.picerija;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Item, Integer> list;

    public Order() {
        this.list = new HashMap<>();
    }

    public void addItem(Item item, int count) throws ItemOutOfStockException {
        if (count > 10) {
            throw new ItemOutOfStockException(item);
        }

        for (Map.Entry<Item, Integer> i : list.entrySet()) {
            if (i.getKey().equals(item)) {
                i.setValue(count);
                return;
            }
        }

        list.put(item, count);
    }

    public int getPrice() {
        return list.entrySet().stream().mapToInt(i -> i.getKey().getPrice() * i.getValue()).sum();
    }

    public void displayOrder() {
        int standard = 0;
        int vegetarian = 0;
        int pepperoni = 0;
        int coke = 0;
        int ketchup = 0;

        for (Map.Entry<Item, Integer> i : list.entrySet()) {
            switch (i.getKey().getType()) {
                case "Standard":
                    standard++;
                    break;
                case "Pepperoni":
                    pepperoni++;
                    break;
                case "Vegetarian":
                    vegetarian++;
                    break;
                case "Coke":
                    coke++;
                    break;
                default:
                    ketchup++;
                    break;
            }
        }

        if (standard != 0) {
            System.out.println();
        }
    }
}