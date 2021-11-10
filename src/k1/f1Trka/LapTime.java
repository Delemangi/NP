package k1.f1Trka;

public class LapTime implements Comparable<LapTime> {
    private final int minutes;
    private final int seconds;
    private final int milliseconds;

    public LapTime(String time) {
        minutes = Integer.parseInt(time.split(":")[0]);
        seconds = Integer.parseInt(time.split(":")[1]);
        milliseconds = Integer.parseInt(time.split(":")[2]);
    }

    @Override
    public int compareTo(LapTime o) {
        if (minutes != o.minutes) {
            return minutes - o.minutes;
        }

        if (seconds != o.seconds) {
            return seconds - o.seconds;
        }

        if (milliseconds != o.milliseconds) {
            return milliseconds - o.milliseconds;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("%01d:%02d:%03d", minutes, seconds, milliseconds);
    }
}