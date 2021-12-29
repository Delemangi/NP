package k2.avtomobili;

import java.util.*;

public class Car implements Comparable<Car> {
    private final String manufacturer;
    private final String model;
    private final int price;
    private final float power;

    public Car(String manufacturer, String model, int price, float power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.power = power;
    }

    @Override
    public int compareTo(Car o) {
        return Comparator.comparing(Car::getPrice).thenComparing(Car::getPower).compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%.0fKW) %d", manufacturer, model, power, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Float.compare(car.power, power) == 0 && manufacturer.equals(car.manufacturer) && model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, price, power);
    }

    public int getPrice() {
        return price;
    }

    public float getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }
}