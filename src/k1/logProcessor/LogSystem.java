package k1.logProcessor;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LogSystem<T extends ILog & Comparable<T>> {
    private final ArrayList<T> logsList;

    public LogSystem(ArrayList<T> logsList) {
        this.logsList = logsList;
    }

    void printResults() {
        LogProcessor<T> firstLogProcessor = x -> x.stream().filter(i -> i.getType().equals("INFO")).collect(Collectors.toCollection(ArrayList::new));

        LogProcessor<T> secondLogProcessor = x -> x.stream().filter(i -> i.getMessage().length() < 100).collect(Collectors.toCollection(ArrayList::new));

        LogProcessor<T> thirdLogProcessor = x -> x.stream().sorted().collect(Collectors.toCollection(ArrayList::new));

        System.out.println("RESULTS FROM THE FIRST LOG PROCESSOR");
        firstLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE SECOND LOG PROCESSOR");
        secondLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));

        System.out.println("RESULTS FROM THE THIRD LOG PROCESSOR");
        thirdLogProcessor.processLogs(logsList).forEach(l -> System.out.println(l.toString()));
    }
}