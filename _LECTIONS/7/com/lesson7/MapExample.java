package com.lesson7;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapExample {


    public static void main(String[] args) {

        final Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        TreeSet<String> set = new TreeSet<>(comparator);
        set.add("Вася");
        set.add("Влад");
        System.out.println(set);
        TreeMap<String, Integer> stringToLengthMap = new TreeMap<>(comparator);

        stringToLengthMap.put("Вася", "Вася".length());
        stringToLengthMap.put("Владислав", "Владислав".length());

        System.out.println(stringToLengthMap);


        final Set< Entry<String, Integer> > entries = stringToLengthMap.entrySet();

        for (Entry<String, Integer> entry : entries) {
            System.out.println("В фамилии " + entry.getKey() + " чило букв = " + entry.getValue());
        }

        for (String key : stringToLengthMap.keySet()) {
            final Integer surnameLength = stringToLengthMap.get(key);
            System.out.println("В фамилии " + key + " чило букв = " + surnameLength);

        }


    }
}
