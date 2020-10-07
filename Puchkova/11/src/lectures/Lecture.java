package lectures;

import java.time.LocalDate;
import java.util.*;

public class Lecture {
    private final String name;
    private final LocalDate time;

    public static final String[] STUDENT_LECTURES = {
            "Мат. анализ",
            "Философия",
            "Английский язык",
            "История",
            "Физкультура"
    };

    public Lecture(String name, LocalDate time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LocalDate getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public void println() {
        System.out.println(name + "\t\t" + time);
    }

    public static Set<Lecture> createLectures(){
        Set<Lecture> lectures = new HashSet<>();
        int numOfLectures = new Random().nextInt(18) + 3;
        for (int i = 0; i < numOfLectures; i++){
            lectures.add(new Lecture(STUDENT_LECTURES[new Random().nextInt(STUDENT_LECTURES.length)], LocalDate.of(2020, 10, new Random().nextInt(5)+1)));
        }
        return lectures;
    }

    public static Set<Lecture> randomLectures(Set<Lecture> lectures){
        List<Lecture> lectureList = new ArrayList<>(lectures);
        Collections.shuffle(lectureList);
        return (new HashSet<>(lectureList.subList(0, new Random().nextInt(lectures.size() - 1) + 1)));
    }
}
