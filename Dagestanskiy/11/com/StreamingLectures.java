package com;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamingLectures {
    public static void main(String[] args) {
        List <Lection> lectionList = initLectionsList();
        List <Student> studentList = initStudentsList(lectionList);

        whoVisitedMatan(studentList);
        studentVisitStatistics(studentList);
        lecturesWithMoreAttendance(studentList);
        studentsWhoAttendedLargestNumberOfLecturesPerDay(studentList,lectionList);
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

    private static void studentsWhoAttendedLargestNumberOfLecturesPerDay(List<Student> studentList, List<Lection> lectionList) {
        List<String[]> mostVisitsPerDayByStudent = new ArrayList<>();
        List<String[]> datesOfLectures = new ArrayList<>();
        Set<LocalDate> dates = new HashSet<>();
        for (Lection lection : lectionList) dates.add(lection.getDate());
        for (LocalDate date : dates) datesOfLectures.add(new String[]{date.toString(), "0"});
        for (Student student : studentList) {
            student.getLections().stream()
                    .map(Lection::getDate)
                    .sorted()
                    .forEach(localDate -> {
                        for (String[] datesOfLecture : datesOfLectures)
                            if (localDate.toString().equals(datesOfLecture[0]))
                                datesOfLecture[1] = Integer.toString(Integer.parseInt(datesOfLecture[1]) + 1);
                    });
            datesOfLectures.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1])));
            mostVisitsPerDayByStudent.add(new String[]{student.getName(), datesOfLectures.get(0)[1], datesOfLectures.get(0)[0]});
            for (String[] datesOfLecture : datesOfLectures) {
                datesOfLecture[1] = "0";
            }
        }
        mostVisitsPerDayByStudent.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1])));
        System.out.println("\n    Студенты, посетившие наибольшее количество лекций в день:  ");
        String s = mostVisitsPerDayByStudent.get(0)[1];
        for (String[] strings : mostVisitsPerDayByStudent)
            if (strings[1].equals(s)) System.out.println(strings[0] + " посетил " + strings[1] + " лекции " +
                    strings[2]);
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

    private static void studentVisitStatistics(List<Student> studentList){
        System.out.println("\n    Статистика посещений для каждого студента: ");
        studentList.stream()
                .forEach(student -> System.out.println(student.getName()+" посетил "
                +student.getLectionsSize()+" лекций."));
    }

    private static void whoVisitedMatan(List<Student> studentList){
        System.out.println("    Список студентов, которые хоть раз посещали "+LectureName.matan.getName()+":");
        AtomicInteger count= new AtomicInteger(1);
        studentList.stream()
                .filter(student->student.getLections().toString().contains(LectureName.matan.getName()))
                .forEach(student -> System.out.println((count.getAndIncrement())+". "+student.getName())
                );
    }

    private static List<Student> initStudentsList(List<Lection> lectionList){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(lectionList,"Кирилл"));
        studentList.add(new Student(lectionList,"Петя"));
        studentList.add(new Student(lectionList,"Иван"));
        studentList.add(new Student(lectionList,"Федя"));
        studentList.add(new Student(lectionList,"Алексей"));
        studentList.add(new Student(lectionList,"Коля"));
        studentList.add(new Student(lectionList,"Артем"));
        studentList.add(new Student(lectionList,"Игорь"));
        studentList.add(new Student(lectionList,"Саша"));
        studentList.add(new Student(lectionList,"Сергей"));
        return studentList;
    }

    private static List<Lection> initLectionsList(){
        List<Lection> lections= new ArrayList<>();
        //расписание на неделю
        LocalDate date;
        for (int i = 0; i <7 ; i++) {
            date = LocalDate.of(2020, 3, i+1);
           if (date.getDayOfWeek()== DayOfWeek.SUNDAY){
               date.plusDays(1L);
               continue;
           }
            for (LectureName lectureName : LectureName.values()) {
                //в среднем по две лекции в день
                if(2<Student.rndIn(0,4)){
                    lections.add(new Lection(lectureName.getName(),date));
                }
            }
            date.plusDays(1L);
        }
        return lections;
    }
}
