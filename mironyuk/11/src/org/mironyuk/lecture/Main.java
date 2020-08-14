package org.mironyuk.lecture;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
    private static final int LECTURES_COUNT = 30;
    private final static String[] STUDENT_ALLOWED_NAMES = new String[]{
            "Алексей",
            "Дмитрий",
            "Оксана",
            "Михаил",
            "Елена",
            "Генадий",
            "Сергей",
            "Александр",
            "Светлана",
            "Мария",
            "Евдоким"
    };
    private final static String[] LECTURE_ALLOWED_NAMES = new String[]{
            "Математика",
            "История",
            "Физика",
            "Физика",
            "Английския язык",
            "Французкий язык",
            "Немецкий язык",
            "Болгарский язык",
            "Философия",
            "Физкультура",
            "История гомеопатии",
            "Культура общения",
            "Программирование на Java",
            "Биология",
            "Матанализ"
    };
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        List<Student> students = createStudents();

        System.out.println("\nСписок студентов с лекциями \n");
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);

        System.out.println("\nСписок студентов, которые хоть раз посещали матанализ\n");
        printStudentsVisitedMath(students);

        System.out.println("\nСтатистика посещений для каждого студентам в формате: имя - количество посещенных лекций\n");
        printStudentsVisitLessonsStats(students);

        System.out.println("\nНазвание дисциплин, имеющих наибольшее количество посещений\n");

        printStudentsSortedByVisitationOfLessons(students);

        System.out.println("\nСтатистика по курсам в формате: название курса - количество разных студентов, которые посетили хотя бы одно занятие\n");

        uniqueStudentsPerLecture(students);

        System.out.println("\nИмена студентов, которые посетили наибольшее количество лекций в день\n");

        printStudentsWithBiggerVisitationPerDate(students);
    }

    private static void uniqueStudentsPerLecture(List<Student> students) {
        students.stream()
                .flatMap((s) -> s.getLectures().stream().map((l) -> new String[]{l.getName(), s.getName()}))
                .collect(Collectors.groupingBy((e) -> e[0], Collectors.counting()))
                .forEach((a, b) -> System.out.println(a + " - " + b));
    }

    private static void printStudentsWithBiggerVisitationPerDate(List<Student> students) {
        Map<String, Map<String, Long>> studentVisitationPerDate = students.stream()
                .flatMap((student) -> student.getLectures().stream().map((lecture) -> new String[]{student.getName(), lecture.date.toString()}))
                .collect(Collectors.groupingBy((pair) -> pair[1], Collectors.groupingBy((pair) -> pair[0], Collectors.counting())));

        for (Map.Entry<String, Map<String, Long>> entry : studentVisitationPerDate.entrySet()) {

            System.out.print(entry.getKey() + " - ");

            Map<Long, List<String>> collect = entry.getValue()
                    .entrySet()
                    .stream()
                    .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

            Optional<Map.Entry<Long, List<String>>> max = collect.entrySet().stream().max(Map.Entry.comparingByKey());

            if (!max.isPresent()) {
                System.out.print("Никого");
            } else {
                System.out.println(Arrays.toString(max.get().getValue().toArray()));
            }
        }
    }

    private static void printStudentsSortedByVisitationOfLessons(List<Student> students) {
        Map<String, Long> lectureNameWithVisitation = students.stream()
                .flatMap(student -> student.getLectures().stream())
                .map(Lecture::getName)
                .collect(Collectors.groupingBy((l) -> l, Collectors.counting()));

        lectureNameWithVisitation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach((v) -> System.out.println(v.getKey() + ": " + v.getValue()))
        ;
    }

    private static void printStudentsVisitLessonsStats(List<Student> students) {
        students
                .stream()
                .map((s) -> new String[]{s.getName(), String.valueOf(s.getLectures().size())})
                .sorted(Comparator.comparing((v) -> v[0]))
                .forEach((arr) -> System.out.println(arr[0] + " - " + arr[1]));
    }

    private static void printStudentsVisitedMath(List<Student> students) {
        students
                .stream()
                .filter((s) -> s.getLectures().stream().anyMatch(l -> l.name.equals("Матанализ")))
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    private static ArrayList<Student> createStudents() {
        Set<String> allowedNames = new HashSet<>(Arrays.asList(STUDENT_ALLOWED_NAMES.clone()));

        Set<Lecture> lectures = createLectures();

        return allowedNames
                .stream()
                .map(n -> new Student(n, randomLectures(lectures)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static HashSet<Lecture> randomLectures(Set<Lecture> lectures) {
        List<Lecture> lecturesList = new ArrayList<>(lectures);

        Collections.shuffle(lecturesList);

        return new HashSet<>(lecturesList.subList(0, random.nextInt(3, 10)));
    }

    private static Set<Lecture> createLectures() {
        List<String> allowedNames = Arrays.asList(LECTURE_ALLOWED_NAMES.clone());

        Set<Lecture> lectures = new HashSet<>();

        for (int i = 0; i < LECTURES_COUNT; i++) {
            String lectureName = allowedNames.get(random.nextInt(0, allowedNames.size()));

            Lecture lecture = new Lecture(lectureName, makeRandomDate());

            lectures.add(lecture);
        }

        return lectures;
    }

    private static LocalDate makeRandomDate() {
        return LocalDate.of(
                2020,
                7,
                random.nextInt(1, 7)
        );
    }
}
