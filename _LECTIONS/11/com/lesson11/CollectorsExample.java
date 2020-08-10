package com.lesson11;

import static com.lesson11.StreamSample.getPersons;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.lesson11.StreamSample.Person;

public class CollectorsExample {

    public static void main(String[] args) {
        final List<Person> persons = getPersons();

        final Map<String, String> nameToProfession = persons
                .stream()
                .collect(Collectors.toMap(p -> p.getName(), p -> p.getProfession(), (one, another) -> one, (Supplier<Map<String, String>>) () -> new TreeMap<>()));




        System.out.println(nameToProfession);


        final Double averageNameLength = persons.stream().collect(Collectors.averagingInt(p -> p.getName().length()));
        final Double averageAnimalCount = persons.stream().collect(Collectors.averagingInt(p -> p.favoriteAnimals.size()));
        System.out.println(averageNameLength);
        System.out.println(averageAnimalCount);


        final Map<String, List<Person>> personToCollection = persons.stream().collect(Collectors.groupingBy(p -> p.getProfession()));
        System.out.println(personToCollection);
    }
}
