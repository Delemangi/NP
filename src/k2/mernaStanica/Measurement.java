package k2.mernaStanica;

import java.util.Date;

public class Measurement implements Comparable<Measurement> {
    private final float temperature;
    private final float wind;
    private final float humidity;
    private final float visibility;
    private final Date date;

    public Measurement(float temperature, float wind, float humidity, float visibility, Date date) {
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s", temperature, wind, humidity, visibility, date.toString());
    }

    @Override
    public int compareTo(Measurement o) {
        if (Math.abs(date.getTime() - o.date.getTime()) < 150000) {
            return 0;
        } else
            return date.compareTo(o.date);
    }

    public Date getDate() {
        return date;
    }

    public float getTemperature() {
        return temperature;
    }
}