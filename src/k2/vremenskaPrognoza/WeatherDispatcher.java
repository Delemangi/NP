package k2.vremenskaPrognoza;

import java.util.*;

public class WeatherDispatcher {
    private final Set<Subscriber> subscribers;

    public WeatherDispatcher() {
        this.subscribers = new HashSet<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        subscribers.forEach(subscriber -> subscriber.setMeasurements(temperature, humidity, pressure));
        System.out.println();
    }

    public void remove(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
}