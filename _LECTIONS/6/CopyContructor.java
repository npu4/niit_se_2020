import java.util.Objects;

public class CopyContructor {

    static class Person {
        private String name;
        private String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }


        public Person(Person toCopy) {
            name = toCopy.name;
            surname = toCopy.surname;
        }

        @Override
        public boolean equals(Object o) {

            if (getClass() != o.getClass()) {
                return false;
            }

            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(surname, person.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname);
        }
    }

    static class PersonWithAge extends Person  {
        int age;

        public PersonWithAge(String name, String surname, int age) {
            super(name, surname);
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            final boolean result = super.equals(o);
            if (!result) {
                return false;
            }


            if (!(o instanceof PersonWithAge)) {
                return false;
            }

            PersonWithAge person = (PersonWithAge) o;
            return age == person.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), age);
        }
    }


    public static void main(String[] args) {

        Person vasya = new Person("Vasya", "Pupkin");
        Person clone = new Person(vasya);
/*
        System.out.println(clone.equals(vasya));
        System.out.println(vasya == clone);*/


        PersonWithAge vasyaWithAge = new PersonWithAge("Vasya", "Pupkin", 18);


        System.out.println(vasya.equals(vasyaWithAge));
        System.out.println(vasyaWithAge.equals(vasya));

    }
}
