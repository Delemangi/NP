package lab3.picerija;

import java.util.Objects;

public class ExtraItem implements Item {
    private final String type;

    public ExtraItem(String type) throws InvalidExtraTypeException {
        if (type.equals("Coke") || type.equals("Ketchup")) {
            this.type = type;
        } else {
            throw new InvalidExtraTypeException("");
        }
    }

    @Override
    public String getType() {
        return "Extra";
    }

    @Override
    public int getPrice() {
        switch (type) {
            case "Coke":
                return 5;
            default:
                return 3;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraItem extraItem = (ExtraItem) o;
        return Objects.equals(type, extraItem.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}