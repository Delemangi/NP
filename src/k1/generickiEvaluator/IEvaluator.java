package k1.generickiEvaluator;

public interface IEvaluator<T extends Comparable<T>> {
    boolean evaluate(T a, T b);
}