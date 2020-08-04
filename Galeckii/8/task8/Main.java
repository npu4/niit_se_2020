package task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Ivan", "Ivanov", 22);
        Animal animal = new Animal("Murzik", "White", 3);

        List<Object> list = new ArrayList<>(Arrays.asList(person, animal));
        String s = Serializer.serialize(list);
        System.out.println(s);

        Deserializer.deserialize(s, Person.class);
        Deserializer.deserialize(s, Animal.class);
    }
}
