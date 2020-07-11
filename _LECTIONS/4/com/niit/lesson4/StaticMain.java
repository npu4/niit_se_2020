package com.niit.lesson4;

public class StaticMain {


    public static void main(String[] args) {
        System.out.println(StaticFields.SOME_CONSTANT);


        StaticFields intance = new StaticFields();
        System.out.println(intance.SOME_CONSTANT);
        intance.SOME_CONSTANT = "1";

        StaticFields intance2 = new StaticFields();
        System.out.println(intance2.SOME_CONSTANT);



    }
}
