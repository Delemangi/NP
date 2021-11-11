package lab4.localDate;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {
    public static void main(String[] args) {
        System.out.println(create());
        System.out.println(parse());
        System.out.println(with().getYear());
        System.out.println(withAdjuster());
        System.out.println(plus());
        System.out.println(minus());
        System.out.println(plusPeriod());
        System.out.println(isAfter());
        System.out.println(until());
    }

    static LocalDate create() {
        return LocalDate.of(2015, 6, 18);
    }

    static LocalDate parse() {
        return LocalDate.parse("2015-06-18");
    }

    static LocalDate with() {
        LocalDate ld = DateAndTimes.LD_20150618;

        return ld.withYear(2015);
    }

    static LocalDate withAdjuster() {
        LocalDate ld = DateAndTimes.LD_20150618;

        return ld.with(TemporalAdjusters.firstDayOfNextYear());
    }

    static LocalDate plus() {
        LocalDate ld = DateAndTimes.LD_20150618;

        return ld.plusMonths(10);
    }

    static LocalDate minus() {
        LocalDate ld = DateAndTimes.LD_20150618;

        return ld.minusDays(10);
    }

    static LocalDate plusPeriod() {
        LocalDate ld = DateAndTimes.LD_20150618;
        Period period = Period.of(1, 2, 3);

        return ld.plus(period);
    }

    static boolean isAfter() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalDate ld2 = DateAndTimes.LD_20150807;

        return ld2.isAfter(ld);
    }

    static Period until() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalDate ld2 = DateAndTimes.LD_20150807;

        return Period.between(ld, ld2);
    }
}