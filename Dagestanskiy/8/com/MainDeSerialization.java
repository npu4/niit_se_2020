import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

class MainDeSerialization {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Collection <Object> objectCollection = new ArrayList<>();
//        objectCollection.add(new PersonAnot("Валерий", "Королев", 30, "Москва", "qq"));
        objectCollection.add(new PersonAnot("Сергей", "Иванов", 40, "Городец", "qw"));
        objectCollection.add(new Animal("Кот", "Барсик", 5, "креветки", true));

        String serializationString = DeSerializator.serialize(objectCollection);
        System.out.println("Коллекция объектов сериализована:");
        System.out.println(serializationString);


        HashSet<Class> classes = new HashSet<>();
        classes.add(PersonAnot.class);
        classes.add(Animal.class);
        Collection<?> objects = DeSerializator.deserealize(serializationString, classes);
        System.out.println("Коллекция объектов десериализована:");
        for (Object object :objects){
            System.out.println(object.toString());
        }



    }
}
