import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetsExample {




    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
     /*   Set<String> stringSet = new HashSet<>();



        stringSet.add("c");
        stringSet.add("a");
        stringSet.add("b");
        if (!stringSet.add("a")) {
            System.out.println("Элемент не добавился");
        }

        System.out.println(stringSet.size());
        System.out.println(stringSet);
*/

        Set<Person> persons = new HashSet<>();
        final Person vasya = new Person("Vasya");
        persons.add(vasya);
        final Person vasya1 = new Person("Vasya");
        persons.add(vasya1);


        System.out.println(persons);



    }
}
