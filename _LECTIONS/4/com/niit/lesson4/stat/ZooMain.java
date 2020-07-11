package com.niit.lesson4.stat;

public class ZooMain {


    public static void main(String[] args) {
        Zoo zoo1 = new Zoo("Лимпопо");
        Zoo zoo2 = new Zoo(Zoo.proposeZooName());


        System.out.println(zoo2.name);

        System.out.println(Zoo.getCreatedZoos());


        System.out.println(zoo1.getRandomVar());
        System.out.println(zoo2.getRandomVar());
    }
}
