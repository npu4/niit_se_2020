package Task3;

import java.time.LocalDate;
import java.util.Random;

public class Lecture {
    private String name;
    private LocalDate date;

    public Lecture(String name) {
        this.name = name;
        this.date = LocalDate.of(2000, 3, new Random().nextInt(3) + 1);
    }

    @Override
    public String toString() {
        return "lection={'" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

}
