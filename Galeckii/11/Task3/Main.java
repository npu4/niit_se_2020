package Task3;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = Util.createStudents();
        System.out.println(students);

        Util.whoVisitMathematicalAnalysis(students);

        Util.AttendanceStatistics(students);

        Util.mostAttendedLectures(students);

        Util.mostVisitedStudents(students, LocalDate.of(2000, 3, 1));

        Util.lecturesStatitstics(students);

    }

}
