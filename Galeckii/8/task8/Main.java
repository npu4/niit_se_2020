package task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Person person = new Person("Ivan", "Ivanov", 22);
        Animal animal = new Animal("Murzik", "White", 3);

        List<Object> list = new ArrayList<>(Arrays.asList(person, animal));
        String s = Serializer.serialize(list);
        System.out.println(s);

        Person newPerson = (Person) Deserializer.deserialize(s, Person.class);
        System.out.println(newPerson);
        Animal newAnimal = (Animal) Deserializer.deserialize(s, Animal.class);
        System.out.println(newAnimal);
    }
}
