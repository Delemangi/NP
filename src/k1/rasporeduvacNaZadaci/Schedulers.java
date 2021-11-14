package k1.rasporeduvacNaZadaci;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Schedulers {
    public static <T extends Task> TaskScheduler<T> getOrdered() {
        return new TaskScheduler<T>() {
            @Override
            public List<T> schedule(T[] tasks) {
                return Arrays.stream(tasks).sorted().collect(Collectors.toList());
            }
        };
    }

    public static <T extends Task> TaskScheduler<T> getFiltered(int order) {
        return tasks -> Arrays.stream(tasks).filter(i -> i.getOrder() < order).collect(Collectors.toList());
    }
}