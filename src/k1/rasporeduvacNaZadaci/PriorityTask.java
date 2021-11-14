package k1.rasporeduvacNaZadaci;

public class PriorityTask implements Task, Comparable<PriorityTask> {
    private final int priority;

    public PriorityTask(int priority) {
        this.priority = priority;
    }

    @Override
    public int getOrder() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("PT -> %d", getOrder());
    }

    @Override
    public int compareTo(PriorityTask o) {
        return Integer.compare(getOrder(), o.getOrder());
    }
}