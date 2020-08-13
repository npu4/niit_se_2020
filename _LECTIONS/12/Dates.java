import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class Dates {


    public static void main(String[] args) {


        final LocalDate now = LocalDate.of(2020, Month.AUGUST, 13);
        final LocalDate anotherNow = LocalDate.now();

        System.out.println(now);
       // System.out.println(anotherNow);


        System.out.println("Плюс неделя");
        final LocalDate plusWeek = now.plusWeeks(1);
        System.out.println(plusWeek);
        System.out.println(now);


        System.out.println("Минус месяц");
        System.out.println(now.minusMonths(1));


        final LocalDate plus30Years = now.plus(3, ChronoUnit.DECADES);
        System.out.println(plus30Years);


        final LocalDate middleOfYear = now.withDayOfYear(182);
        System.out.println("middleOfYear");
        System.out.println(middleOfYear);


        ZonedDateTime zoned = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println(zoned);

        //2020-08-13T15:17:03.067+03:00 - MSK


     /*   final Period between = Period.between(LocalDate.now(), LocalDate.now().withYear(2021));
        System.out.println(between.getDays());*/
    }
}
