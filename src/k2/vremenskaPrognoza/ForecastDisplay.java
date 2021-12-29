package k2.vremenskaPrognoza;

public class ForecastDisplay implements Subscriber {
    private float prevPressure;

    public ForecastDisplay(WeatherDispatcher weatherDispatcher) {
        this.prevPressure = 0;
        weatherDispatcher.register(this);
    }

    @Override
    public void setMeasurements(float temperature, float humidity, float pressure) {
        if (pressure > prevPressure) {
            System.out.println("Forecast: Improving");
        } else if (pressure == prevPressure) {
            System.out.println("Forecast: Same");
        } else {
            System.out.println("Forecast: Cooler");
        }

        prevPressure = pressure;
    }
}