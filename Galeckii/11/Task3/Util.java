package Task3;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Util {
    public static void lecturesStatitstics(List<Student> students) {
        System.out.println("\nДисциплины, имеющие наибольшее количество посещений");
        Map<String, Integer> lectures = createListOfSubjects();

        students.forEach(student -> student.getLectures().forEach(lecture -> {
            lectures.put(lecture.getName(), lectures.get(lecture.getName()) + 1);
        }));
        System.out.println(lectures);
    }

    public static void mostAttendedLectures(List<Student> students) {
        System.out.println("\nСтатистика по курсам");
        Map<String, Integer> lectures = createListOfSubjects();

        students.forEach(student -> {
            Set<String> set = new HashSet<>();
            student.getLectures().forEach(lecture -> set.add(lecture.getName()));
            set.forEach(s -> lectures.put(s, lectures.get(s) + 1));
        });

        System.out.println(lectures);
    }

    public static void mostVisitedStudents(List<Student> students, LocalDate date) {
        System.out.println("\nИмена студентов, которые посетили наибольшее количество лекций в " + date);
        AtomicInteger visitedLectures = new AtomicInteger(0);

        students.forEach(student -> {
            Set<Lecture> lecturesOnCurrentDate = student.getLectures();
            lecturesOnCurrentDate.removeIf(lecture -> !lecture.getDate().equals(date));

            if (lecturesOnCurrentDate.size() > visitedLectures.get()) {
                visitedLectures.set(lecturesOnCurrentDate.size());
            }
        });

        List<Student> attendedStudents = students
                .stream()
                .filter(student -> student.getLectures().size() == visitedLectures.get())
                .collect(Collectors.toList());
        attendedStudents.forEach(student -> System.out.println(student.getName() + " - " + visitedLectures));
    }

    public static void AttendanceStatistics(List<Student> students) {
        System.out.println("\nСтатистика посещений");
        students.forEach(student -> System.out.printf("%s - количество посщенных лекций: %d\n",
                student.getName(), student.getLectures().size()));
    }

    public static void whoVisitMathematicalAnalysis(List<Student> students) {
        System.out.println("Студенты, которые хоть раз посещали матанализ:");
        students.forEach(student -> {
            Set<Lecture> set = student.getLectures();
            set.stream()
                    .filter(lecture -> lecture.getName().equals("матанализ"))
                    .map(lecture -> student.getName())
                    .forEach(System.out::println);
        });
    }

    public static ArrayList<Student> createStudents() {
        return new ArrayList<>(Arrays.asList(
                new Student("John"),
                new Student("Maria"),
                new Student("Alex"),
                new Student("Anna"),
                new Student("Helen"),
                new Student("Butch"),
                new Student("Elvis"),
                new Student("Sarah"),
                new Student("Leo"),
                new Student("Tom")
        ));
    }

    private static Map<String, Integer> createListOfSubjects() {
        Map<String, Integer> lectures = new HashMap<>();
        lectures.put("матанализ", 0);
        lectures.put("философия", 0);
        lectures.put("английкий язык", 0);
        lectures.put("история", 0);
        lectures.put("физкультура", 0);
        return lectures;
    }
}
