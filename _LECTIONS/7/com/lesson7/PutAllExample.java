package com.lesson7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PutAllExample {


    static class Person {
        String name;
        String lastName;


        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(lastName, person.lastName);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, lastName);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<String, Person> mapOne = new HashMap<>();
        Map<String, Person> mapTwo = new HashMap<>();


        Person p1 = new Person("Вася", "Васильев");
        Person p2 = new Person("Иван", "Иванов");
        Person p3 = new Person("Петя", "Петров");

        mapOne.put(p1.lastName, p1);
        mapOne.put(p2.lastName, p2);

        mapTwo.put(p2.lastName, p2);
        mapTwo.put(p3.lastName, p3);


        System.out.println(mapOne);
        System.out.println(mapTwo);


        mapOne.putAll(mapTwo);

        System.out.println(mapOne);

        System.out.println(p1.hashCode());
        System.out.println(System.identityHashCode(p1));


    }
}
