package k1.generickiEvaluator;

public class EvaluatorBuilder<T> {
    public static <T extends Comparable<T>> IEvaluator<T> build(String operator) {
        switch (operator) {
            case ">":
                return (a, b) -> a.compareTo(b) > 0;
            case "==":
                return (a, b) -> a.compareTo(b) == 0;
            case "!=":
                return (a, b) -> a.compareTo(b) != 0;
            case "<":
                return (a, b) -> a.compareTo(b) < 0;
            default:
                return (a, b) -> false;
        }
    }
}