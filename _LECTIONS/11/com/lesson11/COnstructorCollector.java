package com.lesson11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class COnstructorCollector {


    public static void main(String[] args) {


        List<String> strings = Arrays.asList("A", "B", "C", "a");



     //   final TreeSet<String> collect = strings.stream().collect(Collectors.toCollection(TreeSet::new));

        final Comparator<String> comparing = String::compareToIgnoreCase;

      //  final Comparator<String> comparingLambda = (s, str) -> s.compareToIgnoreCase(str);


        final TreeSet<String> collect = strings
                .stream()
                .collect(
                        Collectors.toCollection(() -> new TreeSet<>(comparing)));
        System.out.println(collect);


        strings.stream().map(String::toLowerCase).forEach(System.out::println);







    }
}
