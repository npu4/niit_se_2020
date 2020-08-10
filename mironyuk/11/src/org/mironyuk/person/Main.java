package org.mironyuk.person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Person> persons =
        Arrays.asList(
            new Person("Алексей", 12),
            new Person("Ксения", 52),
            new Person("Дмитрий", 95),
            new Person("Наталья", 23),
            new Person("Иван", 6),
            new Person("Сергей", 46),
            new Person("Владимир", 31),
            new Person("Виталий", 27),
            new Person("Михаил", 4),
            new Person("Генадий", 99),
            new Person("Оксана", 57),
            new Person("Светлана", 47),
            new Person("Дарья", 23));

    System.out.println("\nОтсортированы по имени: \n");

    persons
            .stream()
            .sorted(Comparator.comparing(Person::getName))
            .forEach(System.out::println);

    System.out.println("\nОтсортированы по по возрасту: \n");

    persons
            .stream()
            .sorted(Comparator.comparing(Person::getAge))
            .forEach(System.out::println);
  }
}
