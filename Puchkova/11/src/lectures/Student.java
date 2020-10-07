package lectures;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lectures.Lecture.randomLectures;

public class Student {
    private final String name;
    private final Set<Lecture> lectures;

    private static final String[] STUDENT_NAMES = {
            "Алехандро",
            "Диего",
            "Карлос",
            "Леонардо",
            "Луис",
            "Мануэль",
            "Мигель",
            "Ана",
            "Долорес",
            "Тереса"
    };

    public Student(String name, Set<Lecture> lectures) {
        this.name = name;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lections=" + lectures +
                '}';
    }

    public void println() {
        System.out.println("Студент " + name);
        System.out.println("Лекции: ");
        for (Lecture lecture: lectures) {
            lecture.println();
        }
        System.out.println("-----------------------------------------------");
    }

    public static void printlnList(List<Student> students) {
        System.out.println("----------------- Студенты --------------------");
        for (Student student: students) {
            student.println();
        }
    }

    public static List<Student> randomStudents(Set<Lecture> lectures){
        List<Student> students = new ArrayList<>();
        for (String studentName : STUDENT_NAMES) {
            students.add(new Student(studentName, randomLectures(lectures)));
        }
        return students;
    }
}
