package serialize;

import deserialize.XmlDeserializer;
import forSerialize.Animal;
import forSerialize.Person;

import java.util.ArrayList;
import java.util.List;

public class serializeMain {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Person person = new Person("Вася", 25, "25ВасЯ25");
        Animal animal = new Animal("Мяурицио", "Огурец", "Кот");
        List<Object> forSerialize = new ArrayList<>();
        forSerialize.add(person);
        forSerialize.add(animal);
        String afterSerialize = XmlSerializer.xmlSerialize(forSerialize);
        System.out.println(afterSerialize);
        Person personOne = (Person) XmlDeserializer.deserialize(afterSerialize, Person.class);
        Animal animalOne = (Animal) XmlDeserializer.deserialize(afterSerialize, Animal.class);
        System.out.println(personOne);
        System.out.println(animalOne);

    }

}
