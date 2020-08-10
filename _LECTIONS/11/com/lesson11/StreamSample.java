package com.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamSample {


    public static final String ПРОГРАММИСТ = "Программист";
    public static final String ТЕСТИРОВЩИК = "Тестировщик";

    public static class Person {
        String name;
        String profession;

        List<String> favoriteAnimals = new ArrayList<>();


        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Person(String name, String profession) {
            this.name = name;
            this.profession = profession;
        }

        public Person(String name, String profession, List<String> favoriteAnimals) {
            this.name = name;
            this.profession = profession;
            this.favoriteAnimals = favoriteAnimals;
        }

        public String getName() {
            return name;
        }

        public String getProfession() {
            return profession;
        }
    }


    public static void main(String[] args) {
        List<Person> personList = getPersons();

        System.out.println("Программисты");

        final Function<Person, String> getName = Person::getName;

        personList
                .stream()
                .filter(person -> person.getProfession().equals(ПРОГРАММИСТ))
                .sorted(Comparator.comparing(getName))
                .forEach(person -> System.out.println(person.name));


        System.out.println("\nТестировщики");
        personList
                .stream()
                .filter(person -> person.getProfession().equals(ТЕСТИРОВЩИК))
                .forEach(person -> System.out.println(person.name));


    }

    public static List<Person> getPersons() {
        List<Person> personList = Arrays.asList(
                new Person("Оля", ПРОГРАММИСТ, Arrays.asList("Барсик", "Дружок")),
                new Person("Вася", ПРОГРАММИСТ, Arrays.asList("Золотая рыбка", "Леон")),
                new Person("Петя", ПРОГРАММИСТ),
                new Person("Андрея", ТЕСТИРОВЩИК),
                new Person("Андрея", ПРОГРАММИСТ),
                new Person("Ваня", ТЕСТИРОВЩИК, Arrays.asList("Васька"))
        );
        return personList;
    }
}



