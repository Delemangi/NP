package k1.rasporeduvacNaZadaci;

import java.util.List;

public class TaskRunner<T> {
    public void run(TaskScheduler<T> scheduler, T[] tasks) {
        List<T> order = scheduler.schedule(tasks);
        order.forEach(System.out::println);
    }
}