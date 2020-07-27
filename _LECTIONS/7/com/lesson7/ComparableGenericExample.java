package com.lesson7;

import com.lesson7.PutAllExample.Person;

public class ComparableGenericExample {




    static Comparable max(Comparable o1, Comparable o2) {
        return o1.compareTo(o2) > 0 ? o1 : o2;
    }


    static <T extends Comparable> T maxGeneric(T o1, T o2) {
        return o1.compareTo(o2) > 0 ? o1 : o2;
    }



    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "Z42";

        final Object max = max(s2, s1);
        printStringLength((String) max);
        printStringLength(maxGeneric(s1, s2));


        final Person person = new Person("Vasya", "Pupkin");
       // printStringLength(maxGeneric(person, person)); не работает , т.к. person - не Comparable








    }
    public static void printStringLength(String str) {
        System.out.println("Длина " +  str + ":" +str.length());
    }
}
