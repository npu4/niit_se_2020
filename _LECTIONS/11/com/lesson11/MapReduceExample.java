package com.lesson11;

import static com.lesson11.StreamSample.getPersons;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import com.lesson11.StreamSample.Person;

public class MapReduceExample {


    public static void main(String[] args) {
        final List<Person> persons = getPersons();


    /*    final Optional<String> reduce = persons
                .stream()
                .map(person -> person.getName())
                .reduce((accumulated, name) -> name + " ; " + accumulated);


        reduce.ifPresent( str -> {
            System.out.println(str);
        });
                */

        final String reduce = persons
                .stream()
                .map(person -> person.getName())
                .reduce("", (accumulated, name) -> name + " ; " + accumulated);


        System.out.println(reduce);
    }
}
