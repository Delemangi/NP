package k1.rasporeduvacNaZadaci;

public class TimedTask implements Task, Comparable<TimedTask> {
    private final int time;

    public TimedTask(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("TT -> %d", getOrder());
    }

    @Override
    public int getOrder() {
        return time;
    }

    @Override
    public int compareTo(TimedTask o) {
        return Integer.compare(getOrder(), o.getOrder());
    }
}