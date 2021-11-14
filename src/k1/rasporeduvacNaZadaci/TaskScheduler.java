package k1.rasporeduvacNaZadaci;

import java.util.List;

public interface TaskScheduler<T> {
    List<T> schedule(T[] tasks);
}