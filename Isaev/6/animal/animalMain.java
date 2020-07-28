package animal;

import pair.Pair;

import java.util.*;

public class animalMain {
    public static void main(String[] args) {
        List<Pair<Animal, String>> animals = new ArrayList<>();
        animals.add(new Pair<>(new Animal("Ulk", "Dog"), "Bone"));
        animals.add(new Pair<>(new Animal("Charley", "Cat"), "Fish"));
        animals.add(new Pair<>(new Animal("Honey", "Rabbit"), "Carrot"));
        animals.add(new Pair<>(new Animal("Misha", "Bear"), "Honey"));
        animals.add(new Pair<>(new Animal("Kirs", "Spider"), "Fly"));
        feedAnimals(animals);


    }

    public static void feedAnimals(List<Pair<Animal, String>> animals) {
        for (int i = 0; i < animals.size(); i++) {
            if (i == new Random().nextInt(5)) {
                System.out.println("Счастливое животное " + animals.get(i).getFirst().getName() + " получает двойную порцию " + animals.get(i).getSecond());
            } else
                System.out.println("Животное " + animals.get(i).getFirst().getName() + " с удовольствием съедает " + animals.get(i).getSecond());
        }
    }


}

