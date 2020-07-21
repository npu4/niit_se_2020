package com.niit.lesson5.exception;

public class CheckedPerson {

    String name;

    public CheckedPerson(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Пустое имя недоспустимо");
        }
        this.name = name;
    }


    public static void main(String[] args) {

        try {
            final CheckedPerson somePerson = new CheckedPerson("Петя");
        } catch (InvalidNameException e) {

        } finally {
            System.out.println("Попытались создать человека ");
        }

        CheckedPerson vasys = new CheckedPerson("Vasya");
        System.out.println(vasys.name);


    }
}
