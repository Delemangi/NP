package k2.avtomobili;

import java.util.*;
import java.util.stream.*;

public class CarCollection {
    private final List<Car> cars;

    public CarCollection() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void sortByPrice(boolean ascending) {
        if (ascending) {
            cars.sort(Comparator.naturalOrder());
        } else {
            cars.sort(Comparator.reverseOrder());
        }
    }

    public List<Car> filterByManufacturer(String manufacturer) {
        return cars.stream().filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer)).sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
    }

    public List<Car> getList() {
        return cars;
    }
}