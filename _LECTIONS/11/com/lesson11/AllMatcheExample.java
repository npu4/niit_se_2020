package com.lesson11;

import static com.lesson11.StreamSample.getPersons;

import java.util.List;

import com.lesson11.StreamSample.Person;

public class AllMatcheExample {


    public static void main(String[] args) {


        final List<Person> persons = getPersons();


        final boolean hasO = persons.stream().anyMatch(p -> p.getName().startsWith("О"));

        final boolean allStartsWithO = persons.stream().allMatch(p -> p.getName().startsWith("О"));

        final boolean noneY = persons.stream().noneMatch((p -> p.getName().startsWith("Ы")));

        System.out.println(hasO);
        System.out.println(allStartsWithO);
        System.out.println(noneY);
    }}
