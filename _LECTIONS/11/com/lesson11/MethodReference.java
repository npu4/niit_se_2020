package com.lesson11;

import static com.lesson11.StreamSample.getPersons;

import java.util.List;
import java.util.function.Consumer;

import com.lesson11.StreamSample.Person;

public class MethodReference {




    public static class PersonFormatter {
        String formatPerson(Person p) {
            return String.format("Человек %s, профессия %s, любимые животные %s ", p.name, p.profession, p.favoriteAnimals);
        }
    }

    public static void main(String[] args) {
        final List<Person> persons = getPersons();


       /* System.out.println("Печатаем имена");
        persons.forEach(MethodReference::printName);
           //persons.forEach(p -> printName(p));
       /* persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person p) {
                printName(p);
            }
        });*/
/*

        System.out.println("Печатаем профессии");
        persons.forEach(MethodReference::printProfession);
*/


        PersonFormatter f = new PersonFormatter();
        System.out.println("Печатаем форматированно");
        persons
                .stream()
                .map(f::formatPerson)
                .forEach( System.out::println);


    }




    public static void printName(Person p) {
        System.out.println(p.name);
    }
    public static void printProfession(Person p) {
        System.out.println(p.profession);
    }
}
