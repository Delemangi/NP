package ispit.generickiKlaster;

public abstract class Clusterable<T> {
    protected long ID;

    public abstract long getID();

    public abstract double getDistance(T e);
}