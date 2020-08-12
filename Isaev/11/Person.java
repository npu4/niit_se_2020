import java.util.*;

public class Person {

    String name;
    int age;
    String[] names = {"Вася","Петя","Никита","Олег","Даша","Лена","Катя"};
    int[] ages = {10,20,45,30,32,18,17};

    public Person() {
        this.name = names[new Random().nextInt(names.length)];
        this.age = ages[new Random().nextInt(ages.length)];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persons.add(new Person());
        }
        Collections.sort(persons, Comparator.comparing(Person::getName));
        System.out.println(persons);
        Collections.sort(persons, Comparator.comparing(Person::getAge));
        System.out.println(persons);
    }
}
