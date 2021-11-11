package lab4.zonedDateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        System.out.println(zonedDateTimeOf());
        System.out.println(zonedDateTimeParse());
        System.out.println(zonedDateTimeFormat());
        System.out.println(toPST());
        System.out.println(sameInstantAs());
        System.out.println(sameLocalAs());
    }

    static ZonedDateTime zonedDateTimeOf() {
        return ZonedDateTime.of(2015, 7, 10, 2, 14, 25, 0, ZoneId.of("Asia/Tokyo"));
    }

    static ZonedDateTime zonedDateTimeParse() {
        return ZonedDateTime.parse("2015-06-18T23:07:25.000+09:00[Asia/Tokyo]");
    }

    static String zonedDateTimeFormat() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        return zdt.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_z"));
    }

    static ZonedDateTime toPST() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;

        return ldt.atZone(ZoneId.of("America/Los_Angeles"));
    }

    static ZonedDateTime sameInstantAs() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        return zdt.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
    }

    static ZonedDateTime sameLocalAs() {
        ZonedDateTime zdt = DateAndTimes.ZDT_20150618_23073050;

        return zdt.withZoneSameLocal(ZoneId.of("America/Los_Angeles"));
    }

    static class DateAndTimes {
        public static final LocalDateTime LDT_20150618_23073050 = LocalDateTime.of(2015, 6, 18, 23, 7, 30, 500000000);
        public static final ZonedDateTime ZDT_20150618_23073050 = ZonedDateTime.of(LDT_20150618_23073050, ZoneId.of("Asia/Tokyo"));
    }
}