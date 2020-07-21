package com.niit.lesson5;

import java.util.regex.Pattern;

public class StaticDynamic {



    static class Parent {
        static void printParent(){
            System.out.println("Parent");
        }
    }

    static class Child extends Parent {
        static void printParent(){
            System.out.println("Child");
        }
    }


    public static void main(String[] args) {
        Parent p = new Child();
        Parent.printParent();

    }
}
