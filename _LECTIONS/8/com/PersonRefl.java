package com;

public class PersonRefl {
    String name;
    String surname;
    int age;

    public PersonRefl() {
    }


    public PersonRefl(String name, String lastname, int age) {
        this.name = name;
        this.surname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonRefl{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private int getAge() {
        System.out.println("Вызван геттер age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
