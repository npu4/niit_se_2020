import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateForamtter {


    public static void main(String[] args) {
        final ZonedDateTime now = ZonedDateTime.now();
        final DateTimeFormatter rfc1123DateTime = DateTimeFormatter.RFC_1123_DATE_TIME;
        final String format = rfc1123DateTime.format(now);
        System.out.println(format);


        final DateTimeFormatter russianFormatter = DateTimeFormatter.ofPattern("'Дата:'dd.MM.yyy 'Время:' HH:mm");

        System.out.println(russianFormatter.format(now));


    }
}
