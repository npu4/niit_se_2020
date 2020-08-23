package lectures;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.*;

public class streamingLecturesMain {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student());
        }
        checkVisit(students, "матанализ");
        getStatistic(students);
        maxNumberOfVisits(students);
        maxLecturesInADay(students);
        maxCourseVisit(students);

    }

    static void checkVisit(List<Student> students, String checkLection) {
        System.out.println("Студенты,посетившие " + checkLection + " минимум 1 раз:");
        students
                .stream()
                .filter(student -> student.getLections().stream().anyMatch(lection -> lection.getLectionName().equals(checkLection)))
                .forEach(student -> System.out.println(student.getName()));
    }

    static void getStatistic(List<Student> students) {
        System.out.println("Количество лекций, посещённых каждым студентом:");
        students.stream()
                .forEach(student -> {
                    System.out.println(student.getName() + " - " + student.getLections().size());
                });
    }

    static void maxNumberOfVisits(List<Student> students) {
        System.out.println("Курсы с наибольшей посещаемостью:");
        Map<String, Integer> lectureVisiting = new HashMap<>();
        students.stream()
                .flatMap(student -> student.getLections().stream())
                .forEach(lection -> lectureVisiting.merge(lection.getLectionName(),1, (oldVal,newVal) -> oldVal+newVal));
        lectureVisiting.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    static void maxLecturesInADay(List<Student> students) {
        System.out.println("Студенты,посетившие максимальное количество лекций в день:");
        Map<Student, Integer> studentsAndNumberLections = new HashMap<>();
        students.stream().forEach(student -> {
            Map<LocalDate, Integer> lectionsNumbers = new HashMap<>();
            student.getLections().forEach(lection -> {
                lectionsNumbers.merge(lection.getLectionDate(), 1, (oldVal, newVal) -> oldVal + newVal);
                List<Integer> lectionNumbersValue = new ArrayList<>();
                lectionsNumbers.entrySet().stream()
                        .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                        .forEach(k -> lectionNumbersValue.add(k.getValue()));
                studentsAndNumberLections.put(student, lectionNumbersValue.get(0));
            });
            studentsAndNumberLections.entrySet().stream().sorted(Map.Entry.<Student, Integer>comparingByValue().reversed()).forEach(System.out::println);
            });
    }

    static void maxCourseVisit(List<Student> students) {
        Map<String, Integer> visitCourse = new HashMap<>();
        visitCourse.put("матанализ", 0);
        visitCourse.put("английский язык", 0);
        visitCourse.put("физкультура", 0);
        visitCourse.put("история", 0);
        visitCourse.put("философия", 0);
        students.forEach(student -> {
            Set<String> setLection = new HashSet<>();
            student.getLections().forEach(lecture -> setLection.add(lecture.getLectionName()));
            setLection.forEach(lection -> visitCourse.merge(lection, 1,(oldVal,newVal)->oldVal + newVal));
        });
        System.out.println(visitCourse);

    }
}

