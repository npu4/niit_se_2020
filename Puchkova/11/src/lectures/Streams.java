package lectures;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class Streams {
    public static void didAttendLecture(List<Student> students, String nameLecture) {
        System.out.println("Студенты, которые посещали " + nameLecture + ":");
        students.stream()
                .filter(student -> student.getLectures().stream()
                        .anyMatch(lecture1 -> lecture1.getName().equals(nameLecture)))
                .map(Student::getName)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void statisticStudents(List<Student> students) {
        System.out.println("Статистика посещённых лекций:");
        students.stream()
                .forEach(student -> System.out.println(student.getName() + " - " + student.getLectures()
                        .stream()
                        .count()));
        System.out.println();
    }

    public static void maxVisitedLectures(List<Student> students) {
        System.out.println("Дисциплины, имеющие наибольшее количество посещений:");
        Map<Lecture, Long> lectures = students.stream()
                .flatMap(student -> student.getLectures().stream())
                .collect(groupingBy(l -> l, counting()));

        long maxNumOfVisits = 0L;

        for (Map.Entry<Lecture, Long> lecture : lectures.entrySet()) {
            if (maxNumOfVisits < lecture.getValue()) {
                maxNumOfVisits = lecture.getValue();
            }
        }

        Long finalMaxNumOfVisits = maxNumOfVisits;
        lectures.entrySet().stream()
                .filter(lectureLongEntry -> lectureLongEntry.getValue().equals(finalMaxNumOfVisits))
                .forEach(lectureLongEntry -> lectureLongEntry.getKey().println());
        System.out.println();
    }

    public static void maxVisitedStudents(List<Student> students) {
        System.out.println("Студенты, посетившие наибольшее количество лекций в день:");
        Map<String, Map<LocalDate, Long>> lectureLongMap = new HashMap<>();
        for (Student student : students) {
            Map<LocalDate, Long> collect = student.getLectures().stream()
                    .collect(groupingBy(Lecture::getTime, Collectors.counting()));
            lectureLongMap.put(student.getName(), collect);
        }

        long maxNumOfVisits = 0;

        for (Map.Entry<String, Map<LocalDate, Long>> entry : lectureLongMap.entrySet()) {
           for (Map.Entry<LocalDate, Long> entry1 : entry.getValue().entrySet()) {
               if(maxNumOfVisits < entry1.getValue()){
                   maxNumOfVisits = entry1.getValue();
               }
            }
        }

        Long finalMaxNumOfVisits = maxNumOfVisits;

        for (Map.Entry<String, Map<LocalDate, Long>> entry : lectureLongMap.entrySet())
        {
            boolean boolMaxVisitsStudent = entry.getValue().values().stream()
                    .anyMatch(finalMaxNumOfVisits::equals);
            if(boolMaxVisitsStudent){
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
    }

    public static void statisticLectures(List<Student> students) {
        System.out.println("Статистика посещённых лекций:");
        Map<Lecture, Long> lectures = students.stream()
                .flatMap(student -> student.getLectures().stream())
                .collect(groupingBy(l -> l, counting()));

        lectures.entrySet().stream()
                .forEach(lectureLongEntry -> System.out.println(lectureLongEntry.getKey().getName() + " "
                        + lectureLongEntry.getKey().getTime() + " - " + lectureLongEntry.getValue()));
        System.out.println();
    }
}
