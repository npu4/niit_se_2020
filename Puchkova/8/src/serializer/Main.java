package serializer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import static serializer.Deserializer.deserialize;
import static serializer.Serializer.serialize;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Collection<Person> persons = new ArrayList<>();
        Person person1 = new Person("Коля", 23, "qwerty123"); persons.add(person1);
        Person person2 = new Person("Наташа", 22, "qwerty321"); persons.add(person2);

        String serializePersons = serialize(persons);
        System.out.println(serializePersons);

        String forDeserializePerson = "<Человек> \n" +
                "\t<Имя>Наташа</Имя>\n" +
                "\t<Возраст>22</Возраст>\n" +
                "</Человек> \n";
        System.out.println(deserialize(forDeserializePerson, Person.class));
        System.out.println(person2);
        System.out.println();

        Collection<ShopItem> shopItems = new ArrayList<>();
        ShopItem shopItem1 = new ShopItem("Яблоко", 50, true, 1234); shopItems.add(shopItem1);
        ShopItem shopItem2 = new ShopItem("Молоко", 70, false, 5566); shopItems.add(shopItem2);
        ShopItem shopItem3 = new ShopItem("Хлеб", 20, true, 7890); shopItems.add(shopItem3);

        String serializeShopItems = serialize(shopItems);
        System.out.println(serializeShopItems);

        String forDeserializeShopItem = "<title>Яблоко</title>\n" +
                "<price>50</price>";
        System.out.println(deserialize(forDeserializeShopItem, ShopItem.class));
        System.out.println(shopItem1);
    }
}
