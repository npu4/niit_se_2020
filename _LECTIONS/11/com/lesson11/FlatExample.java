package com.lesson11;

import static com.lesson11.StreamSample.getPersons;

import java.util.List;
import java.util.stream.Collectors;

import com.lesson11.StreamSample.Person;

public class FlatExample {


    public static void main(String[] args) {
        final List<Person> persons = getPersons();


        final List<String> collect = persons.stream()
                .flatMap(person -> person.favoriteAnimals.stream())
                .collect(Collectors.toList());


        System.out.println("Всего животных " + collect.size());
        System.out.println("Их имена " + collect);

    }
}
