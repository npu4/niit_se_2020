package org.mironyuk.lecture;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Lecture math = new Lecture("Математика", LocalDate.of(2020, 7, 12));
    Lecture history = new Lecture("История", LocalDate.of(2020, 7, 12));
    Lecture physic = new Lecture("Физика", LocalDate.of(2020, 7, 12));
    Lecture englishLanguage = new Lecture("Английския язык", LocalDate.of(2020, 7, 12));
    Lecture frenchLanguage = new Lecture("Французкий язык", LocalDate.of(2020, 7, 13));
    Lecture germanLanguage = new Lecture("Немецкий язык", LocalDate.of(2020, 7, 13));
    Lecture bulgarian = new Lecture("Болгарский язык", LocalDate.of(2020, 7, 13));
    Lecture philosophy = new Lecture("Философия", LocalDate.of(2020, 7, 14));
    Lecture physicalCulture = new Lecture("Физкультура", LocalDate.of(2020, 7, 14));
    Lecture homeopathyHistory = new Lecture("История гомеопатии", LocalDate.of(2020, 7, 15));
    Lecture communicationCulture = new Lecture("Культура общения", LocalDate.of(2020, 7, 15));
    Lecture javaProgramming = new Lecture("Программирование на Java", LocalDate.of(2020, 7, 16));
    Lecture biology = new Lecture("Биология", LocalDate.of(2020, 7, 16));
    Lecture mathematicalAnalysis = new Lecture("Матанализ", LocalDate.of(2020, 7, 16));

    List<Student> students = Arrays.asList(
          new Student("Алексей", new HashSet<>(Arrays.asList(javaProgramming, math, mathematicalAnalysis, physic, englishLanguage))),
          new Student("Дмитрий", new HashSet<>(Arrays.asList(javaProgramming, frenchLanguage, homeopathyHistory))),
          new Student("Оксана", new HashSet<>(Arrays.asList(javaProgramming, germanLanguage))),
          new Student("Михаил", new HashSet<>(Arrays.asList(javaProgramming, physic, biology, philosophy))),
          new Student("Елена", new HashSet<>(Arrays.asList(javaProgramming, bulgarian, math, mathematicalAnalysis, physicalCulture))),
          new Student("Генадий", new HashSet<>(Arrays.asList(javaProgramming, physic, bulgarian, history))),
          new Student("Сергей", new HashSet<>(Arrays.asList(javaProgramming, physic, communicationCulture, frenchLanguage))),
          new Student("Александр", new HashSet<>(Arrays.asList(javaProgramming, philosophy, physicalCulture))),
          new Student("Светлана", new HashSet<>(Arrays.asList(javaProgramming, germanLanguage, communicationCulture))),
          new Student("Мария", new HashSet<>(Arrays.asList(javaProgramming, homeopathyHistory, biology))),
          new Student("Евдоким", new HashSet<>(Arrays.asList(javaProgramming, englishLanguage, physic, math, mathematicalAnalysis, communicationCulture)))
    );

    System.out.println("\nСписок студентов, которые хоть раз посещали матанализ\n");

    System.out.println("\nСтатистика посещений для каждого студентам в формате: имя - количество посещенных лекций\n");

    System.out.println("\nНазвание дисциплин, имеющих наибольшее количество посещений\n");

    System.out.println("\nИмена студентов, которые посетили наибольшее количество лекций в день\n");

    System.out.println("\nСтатистика по курсам в формате: название курса - количество разных студентов, которые посетили хотя бы одно занятие\n");
  }
}
