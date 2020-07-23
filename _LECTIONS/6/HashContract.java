import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class HashContract {


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

        Set<Person> set = new HashSet<>();
        final Person вася = new Person("вася");
        set.add(вася);


        вася.name = "Вася";

        if (!set.contains(вася)) {
            System.out.println("Вася потерялся");
        }
        set.add(вася);


        System.out.println(set);


    }
}
