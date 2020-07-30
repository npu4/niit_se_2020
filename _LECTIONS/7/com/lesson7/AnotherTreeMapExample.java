package com.lesson7;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

import com.lesson7.PutAllExample.Person;

public class AnotherTreeMapExample {


    static class A {
        String a;

        public A(String a) {
            this.a = a;
        }

        public String getA() {
            return a;
        }

        @Override
        public String toString() {
            return "A{" +
                    "a='" + a + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        final Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };


        TreeMap<String, Integer> stringToLengthMap = new TreeMap<>(comparator);

        stringToLengthMap.put("Вася", 4);
        stringToLengthMap.put("Петя", 5);

        System.out.println(stringToLengthMap);


        final Comparator<String> aComparator1 = Comparator.nullsFirst(Comparator.naturalOrder());
        final Comparator<A> aComparator = Comparator.comparing(A::getA, aComparator1);

        TreeSet<A> set = new TreeSet<>(aComparator);

        set.add(new A("A"));
        set.add(new A("C"));
        set.add(new A("B"));
        set.add(new A("A"));
        set.add(new A("C"));
        set.add(new A("B"));
        set.add(new A(null));
        set.add(new A(null));

        System.out.println(set);

    }
}
