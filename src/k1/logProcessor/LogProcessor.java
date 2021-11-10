package k1.logProcessor;

import java.util.ArrayList;

public interface LogProcessor<T> {
    ArrayList<T> processLogs(ArrayList<T> logs);
}