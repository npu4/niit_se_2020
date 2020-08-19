package streamingLectures;

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
        students.stream()
                .forEach(student -> {
                    Set<Lection> setLection = student.getLections();
                    setLection.stream()
                            .filter(lection -> lection.getLectionName().equals(checkLection))
                            .map(lection -> student)
                            .distinct()
                            .map(student1 -> student.getName())
                            .forEach(System.out::println);
                });
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
        lectureVisiting.put("матанализ", 0);
        lectureVisiting.put("английский язык", 0);
        lectureVisiting.put("физкультура", 0);
        lectureVisiting.put("история", 0);
        lectureVisiting.put("философия", 0);
        students.stream()
                .forEach(student -> student.getLections().forEach(lection -> {
                    lectureVisiting.put(lection.getLectionName(), lectureVisiting.get(lection.getLectionName()) + 1);
                }));
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
                if (lectionsNumbers.getOrDefault(lection.getLectionDate(), -1) == -1) {
                    lectionsNumbers.putIfAbsent(lection.getLectionDate(), 1);
                } else {
                    lectionsNumbers.put(lection.getLectionDate(), lectionsNumbers.get(lection.getLectionDate()) + 1);
                }
            });
            List<Integer> lectionNumbersValue = new ArrayList<>();
            lectionsNumbers.entrySet().stream()
                    .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                    .forEach(k -> lectionNumbersValue.add(k.getValue()));
            studentsAndNumberLections.put(student, lectionNumbersValue.get(0));
        });
        studentsAndNumberLections.entrySet().stream().sorted(Map.Entry.<Student, Integer>comparingByValue().reversed()).forEach(System.out::println);
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
            setLection.forEach(lection -> visitCourse.put(lection, visitCourse.get(lection) + 1));
        });
        System.out.println(visitCourse);

    }
}

