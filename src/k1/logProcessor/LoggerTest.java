package k1.logProcessor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//public class LoggerTest {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int firstCount = Integer.parseInt(sc.nextLine());
//
//        ArrayList<RealLog> realLogs = IntStream.range(0, firstCount)
//                .mapToObj(i -> RealLog.createLog(sc.nextLine()))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        int secondCount = Integer.parseInt(sc.nextLine());
//
//        ArrayList<DummyLog> dummyLogs = IntStream.range(0, secondCount)
//                .mapToObj(i -> DummyLog.createLog(sc.nextLine()))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        LogSystem<RealLog> realLogSystem = new LogSystem<>(realLogs);
//        LogSystem<DummyLog> dummyLogSystem = new LogSystem<>(dummyLogs);
//
//        System.out.println("===REAL LOGS SYSTEM RESULTS===");
//        realLogSystem.printResults();
//        System.out.println("===DUMMY LOGS SYSTEM RESULTS===");
//        dummyLogSystem.printResults();
//    }
//}