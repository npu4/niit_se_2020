package com;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class StreamingLectures {
    public static void main(String[] args) {
        List<Lection> lectionList = initLectionsList();
        List<Student> studentList = initStudentsList(lectionList);

        whoVisitedMatan(studentList);
        studentVisitStatistics(studentList);
        lecturesWithMoreAttendance(studentList);
        studentsWhoAttendedLargestNumberOfLecturesPerDay(studentList);
        lectureStatistics(studentList);

    }

    private static void lectureStatistics(List<Student> studentList) {
        List<String[]> statistics = new ArrayList<>();
        for (LectureName lectureName : LectureName.values()) statistics.add(new String[]{lectureName.getName(), "0"});

        for (String[] statistic : statistics) {
            String s = statistic[0];
            long count = studentList.stream()
                    .filter(student -> student.getLections().toString().contains(s))
                    .count();
            if (count > 0) statistic[1] = Integer.toString((int) (Integer.parseInt(statistic[1]) + count));
        }
        System.out.println("\n    Статистика посещений по лекциям:");
        System.out.println("    (количество разных студентов посетивших хотя бы одну лекцию)");
        for (String[] statistic : statistics) System.out.println(statistic[0] + " -  " + statistic[1] + " студентов.");
    }

    private static void studentsWhoAttendedLargestNumberOfLecturesPerDay(List<Student> studentList) {
        Map<String, Integer> mostVisitsPerDayByStudent = new HashMap<>();
        studentList.forEach(student -> {
            Map<LocalDate, Integer> numberLection = new HashMap<>();
            student.getLections().forEach(lection -> numberLection.merge(lection.getDate(), 1, Integer::sum));
            mostVisitsPerDayByStudent.put(student.getName(), Collections.max(numberLection.values(), Comparator.comparingInt(o -> o)));
        });
        List<Map.Entry<String, Integer>> list = new ArrayList(mostVisitsPerDayByStudent.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Integer max = list.get(0).getValue();
        System.out.println("\n    Студенты, посетившие наибольшее количество лекций в день:  ");
        for (Map.Entry<String, Integer> l : list)
            if (l.getValue().equals(max))
                System.out.println("Студент " + l.getKey() + " посетил " + l.getValue() + " лекции.");
    }


    private static void lecturesWithMoreAttendance(List<Student> studentList) {
        List<String[]> attendanceOfLectures = new ArrayList<>();
        for (LectureName lectureName : LectureName.values()) {
            attendanceOfLectures.add(new String[]{lectureName.getName(), "0"});
        }
        studentList.stream()
                .flatMap(student -> student.getLections().stream())
                .map(Lection::getName)
                .forEach(s -> {
                    for (String[] strings : attendanceOfLectures) {
                        if (Objects.equals(strings[0], s))
                            strings[1] = Integer.toString(Integer.parseInt(strings[1]) + 1);
                    }
                });
        attendanceOfLectures.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1])));
        System.out.println("\n    Название лекций, имеющих наибольшее количество посещений: ");
        String s = attendanceOfLectures.get(0)[1];
        for (String[] attendanceOfLecture : attendanceOfLectures) {
            if (attendanceOfLecture[1].equals(s))
                System.out.println("Название лекции: " + attendanceOfLecture[0] +
                        ". Количество посещений: " + attendanceOfLecture[1]);
        }
    }

    private static void studentVisitStatistics(List<Student> studentList) {
        System.out.println("\n    Статистика посещений для каждого студента: ");
        studentList
                .forEach(student -> System.out.println(student.getName() + " посетил "
                        + student.getLectionsSize() + " лекций."));
    }

    private static void whoVisitedMatan(List<Student> studentList) {
        System.out.println("    Список студентов, которые хоть раз посещали " + LectureName.matan.getName() + ":");
        AtomicInteger count = new AtomicInteger(1);
        for (Student student : studentList) {
            student.getLections().stream()
                    .map(Lection::getName)
                    .distinct()
                    .filter(s -> s.equals(LectureName.matan.getName()))
                    .forEach(s -> System.out.println((count.getAndIncrement()) + ". " + student.getName()));
        }
    }

    private static List<Student> initStudentsList(List<Lection> lectionList) {
        List<Student> studentList = new ArrayList<>();
        String[] studentName = new String[]{"Кирилл", "Петя", "Иван", "Федя", "Алексей", "Коля",
                "Артем", "Игорь", "Саша", "Сергей"};
        for (String s : studentName) studentList.add(new Student(lectionList, s));
        return studentList;
    }

    private static List<Lection> initLectionsList() {
        List<Lection> lections = new ArrayList<>();
        //расписание на неделю
//        LocalDate date;
        for (int i = 0; i < 7; i++) {
            LocalDate date = LocalDate.of(2020, 3, i + 1);
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                date.plusDays(1L);
                continue;
            }
            for (LectureName lectureName : LectureName.values()) {
                //в среднем по две лекции в день
                if (2 < Student.rndIn(0, 4)) {
                    lections.add(new Lection(lectureName.getName(), date));
                }
            }
            date.plusDays(1L);
        }
        return lections;
    }
}
