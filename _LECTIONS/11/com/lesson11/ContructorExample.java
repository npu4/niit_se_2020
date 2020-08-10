package com.lesson11;

import java.util.ArrayList;
import java.util.List;

import com.lesson11.StreamSample.Person;

public class ContructorExample {



    interface PersonFactory {
        Person getPerson();
    }

    public static void main(String[] args) {


        PersonFactory factory = Person::new;
       /* PersonFactory factoryLambda = () -> new Person();
        PersonFactory anonymousFactory = new PersonFactory() {
            @Override
            public Person getPerson() {
                return new Person();
            }
        };*/


        List<Person> emptyPerson = new ArrayList<>();
        for (int ai = 0; ai < 5; ai++) {
            emptyPerson.add(factory.getPerson());
        }


        System.out.println(emptyPerson);





    }
}
