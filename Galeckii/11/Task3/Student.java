package Task3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {
    String name;
    Set<Lecture> lectures;
    private final String[] subjects =
            new String[]{"матанализ", "философия", "английкий язык", "история", "физкультура"};

    public Student(String name) {
        this.name = name;
        this.lectures = createLections();
    }

    private Set<Lecture> createLections() {
        Random r = new Random();
        Set<Lecture> lectures = new HashSet<>();
        int numberOfLections = r.nextInt(4) + 1;
        for (int i = 0; i < numberOfLections; i++) {
            lectures.add(new Lecture(subjects[r.nextInt(subjects.length)]));
        }
        return lectures;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ",\t lections=" + lectures +
                "}\n";
    }

    public String getName() {
        return name;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }
}
