import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjuster {


    public static void main(String[] args) {


        final LocalDate now = LocalDate.now();

        final LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());


        System.out.println(now
                .withMonth(2)
                .plusYears(1)
                .with(TemporalAdjusters.lastDayOfMonth()));




    }
}
