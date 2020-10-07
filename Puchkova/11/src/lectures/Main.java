package lectures;

import java.util.*;

import static lectures.Lecture.createLectures;
import static lectures.Streams.*;
import static lectures.Student.printlnList;
import static lectures.Student.randomStudents;

public class Main {
    public static void main(String[] args) {
        Set<Lecture> lectures = createLectures();
        List<Student> students = randomStudents(lectures);
        printlnList(students);

        didAttendLecture(students, "Мат. анализ");

        statisticStudents(students);

        maxVisitedLectures(students);

        maxVisitedStudents(students);

        statisticLectures(students);
    }
}
