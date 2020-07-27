package com.lesson7;

import java.util.HashMap;
import java.util.Objects;

import com.lesson7.PutAllExample.Person;

public class EqualsHashCodeContract {

    static class PersonWithAge {
        String name;
        int age;

        public PersonWithAge(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "PersonWithAge{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonWithAge that = (PersonWithAge) o;
            return age == that.age &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return 42;
        }

    }


    public static void main(String[] args) {
        HashMap<PersonWithAge, Integer> personToAge =new HashMap<>();
        final PersonWithAge vasya = new PersonWithAge("Vasya", 18);
        personToAge.put(vasya, 18);

        System.out.println(personToAge);


        vasya.age = 19;
        personToAge.put(vasya, 19);

        System.out.println(personToAge);

    }
}
