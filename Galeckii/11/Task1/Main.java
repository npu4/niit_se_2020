package Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(
                Arrays.asList(new Person("Yan", 23), new Person("Ann", 22), new Person("John", 33)));

        persons.sort(Comparator.comparing(o -> o.name));
        System.out.println(persons);
        persons.sort(Comparator.comparing(o -> o.age));
        System.out.println(persons);

    }
}
