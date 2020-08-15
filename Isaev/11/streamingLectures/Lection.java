package streamingLectures;

import java.time.LocalDate;
import java.util.Random;

public class Lection {

    public String[] lectionNames = {"матанализ", "английский язык", "физкультура", "история", "философия"};
    String lectionName;
    LocalDate lectionDate;

    public Lection() {
        this.lectionName = lectionNames[new Random().nextInt(lectionNames.length)];
        this.lectionDate = LocalDate.of(2020, 8 + new Random().nextInt(3), 20 + new Random().nextInt(6));
    }

    public String getLectionName() {
        return lectionName;
    }

    public LocalDate getLectionDate() {
        return lectionDate;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "lectionName='" + lectionName + '\'' +
                '}';
    }

}
