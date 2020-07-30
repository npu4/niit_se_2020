package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapVsSet {



    public static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }



    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>();
        longs.add(42L);

        longs.remove("42");


        List<Number> numbers = new ArrayList<>();
        numbers.add(42L);
        numbers.add(24);
        numbers.add(13d);

        removeOneCollectionFromAnother(numbers, longs);
        System.out.println(numbers);

    }

    public  static void removeOneCollectionFromAnother(Collection<?> toClear, Collection<?> toCheck) {
        for (Object o : toCheck) {
            toClear.remove(o);
        }
    }
}
