package k2.vremenskaPrognoza;

public class CurrentConditionsDisplay implements Subscriber {
    public CurrentConditionsDisplay(WeatherDispatcher wd) {
        wd.register(this);
    }

    @Override
    public void setMeasurements(float temperature, float humidity, float pressure) {
        System.out.printf("Temperature: %.1fF%nHumidity: %.1f%%%n", temperature, humidity);
    }
}