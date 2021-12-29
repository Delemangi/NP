package k2.vremenskaPrognoza;

public interface Subscriber {
    void setMeasurements(float temperature, float humidity, float pressure);
}