package person.sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Анна", 14));
        people.add(new Person("Вера", 61));
        people.add(new Person("Саша", 77));
        people.add(new Person("Дима", 12));
        people.add(new Person("Лера", 43));
        people.add(new Person("Боря", 5));


        Collections.sort(people, (person1, person2) -> person1.getName().compareTo(person2.getName()));
        System.out.println(people.toString());

        Collections.sort(people, (person1, person2) -> person1.getAge()- person2.getAge());
        System.out.println(people.toString());
    }
}
