import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {



    static class Animal implements Comparable<Animal> {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Animal o) {
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        TreeSet<Animal> animals = new TreeSet<>();


        animals.add(new Animal("Dog"));
        animals.add(new Animal("ACat"));
        animals.add(new Animal("Wolf"));
        animals.add(new Animal("Fox"));
        System.out.println(animals);



        TreeSet<Animal> animalsByLengthOfName = new TreeSet<>(new Comparator<Animal>() {

            String soemField = "str";

            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.name.length() - o2.name.length();
            }
        });

        animalsByLengthOfName.add(new Animal("Dog"));
        animalsByLengthOfName.add(new Animal("ACat"));
        animalsByLengthOfName.add(new Animal("Wolf"));
        animalsByLengthOfName.add(new Animal("Fox"));


        System.out.println(animalsByLengthOfName);
    }

}
