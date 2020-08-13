import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Periods {


    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        final LocalDate endOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());


        final Period between = Period.between(now, endOfMonth);

        System.out.println(between.getDays() + 1);


        final LocalDate endOfYear = now.with(TemporalAdjusters.lastDayOfYear());
        final Period tillEndOfYear = Period.between(now, endOfYear);
        System.out.println(tillEndOfYear.getDays());


        final long untillEndOfYearCorrect = ChronoUnit.DAYS.between(now, endOfYear);
        System.out.println(untillEndOfYearCorrect);

    }
}
