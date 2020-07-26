package animal;

import java.util.*;

public class animalMain {
    public static void main(String[] args) {
        Animal Dog = new Animal("Ulk", "Dog");
        Animal Cat = new Animal("Charley", "Cat");
        Animal Rabbit = new Animal("Honey", "Rabbit");
        Animal Bear = new Animal("Misha", "Bear");
        Animal Spider = new Animal("Kirs", "Spider");
        ArrayList<AnimalToFavouriteFood> animals = new ArrayList<>();
        animals.add(new AnimalToFavouriteFood(Dog, "Bone"));
        animals.add(new AnimalToFavouriteFood(Cat, "Fish"));
        animals.add(new AnimalToFavouriteFood(Rabbit, "Carrot"));
        animals.add(new AnimalToFavouriteFood(Bear, "Honey"));
        animals.add(new AnimalToFavouriteFood(Spider, "Fly"));
        feedAnimals(animals);


    }

    public static void feedAnimals(ArrayList<AnimalToFavouriteFood> animals) {
        int numberOfLuckyAnimal = new Random().nextInt(5);
        for (int i = 0; i < animals.size(); i++) {
            if (i == numberOfLuckyAnimal) {
                System.out.println("Счастливое животное " + animals.get(i).animal.toString() + " получает двойную порцию " + animals.get(i).getFavouriteFood());
            } else
                System.out.println(String.format("Животное " + animals.get(i).animal.toString() + " с удовольствием съедает " + animals.get(i).getFavouriteFood()));
        }
    }


}

