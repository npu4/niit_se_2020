package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';

    }

    public static void main(String[] args) {

        List<Person> personList = getPersons();
        personList.sort(Comparator.comparing(person -> person.name));
        System.out.println("Сортируем по имени:");
        personList.forEach(person -> System.out.println("Имя: "+person.name+" Возраст: "+person.age));

        personList.sort(Comparator.comparingInt(person->person.age));
        System.out.println("Сортируем по возрасту:");
        personList.forEach(person -> System.out.println("Возраст: "+person.age+" Имя: "+person.name));

    }
    private static List<Person> getPersons() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Петя", 20));
        result.add(new Person("Оля", 25));
        result.add(new Person("Саша", 30));
        result.add(new Person("Вова", 40));
        result.add(new Person("Игорь", 50));
        result.add(new Person("Тамара", 35));
        result.add(new Person("Аня", 18));
        return result;
    }

}

