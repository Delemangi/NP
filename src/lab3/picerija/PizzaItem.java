package lab3.picerija;

import java.util.Objects;

public class PizzaItem implements Item {
    private final String type;

    public PizzaItem(String type) throws InvalidPizzaTypeException {
        if (type.equals("Standard") || type.equals("Pepperoni") || type.equals("Vegetarian")) {
            this.type = type;
        } else {
            throw new InvalidPizzaTypeException("");
        }
    }

    @Override
    public String getType() {
        return "Pizza";
    }

    @Override
    public int getPrice() {
        switch (type) {
            case "Standard":
                return 10;
            case "Pepperoni":
                return 12;
            default:
                return 8;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaItem pizzaItem = (PizzaItem) o;
        return Objects.equals(type, pizzaItem.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}