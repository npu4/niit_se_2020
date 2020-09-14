package z2.animals;

import z1.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Pair<Animal,String>> animalAndDishes = new ArrayList<>();
        animalAndDishes.add(new Pair<>(new Animal("Пушок", "Кот"), "Скумбрия"));
        animalAndDishes.add(new Pair<>(new Animal("Феликс", "Хомяк"), "Семечки"));
        animalAndDishes.add(new Pair<>(new Animal("Бим", "Собака"), "Паштет"));
        animalAndDishes.add(new Pair<>(new Animal("Машуша", "Кошка"), "Морковь"));
        animalAndDishes.add(new Pair<>(new Animal("Кнопа", "Кошка"), "Карась"));
        animalAndDishes.add(new Pair<>(new Animal("Майя", "Кошка"), "Молочная каша"));
        animalAndDishes.add(new Pair<>(new Animal("Кеша", "Попугай"), "Банан"));
        animalAndDishes.add(new Pair<>(new Animal("Женька", "Хомячиха"), "Яблоко"));

        feedAnimals(animalAndDishes);
    }

    public static void feedAnimals(List<Pair<Animal, String>> listOfAnimals) {
        int numOfHappyAnimal = new Random().nextInt(listOfAnimals.size());
        for (int i = 0; i < listOfAnimals.size(); i++) {
            if(i == numOfHappyAnimal){
                System.out.println("Счастливое животное " + listOfAnimals.get(i).getFirst().getName() + " получает двойную порцию " + listOfAnimals.get(i).getSecond());
            }
            else {
                System.out.println(listOfAnimals.get(i).getFirst().getType() + " " + listOfAnimals.get(i).getFirst().getName() + " с радостью съедает " + listOfAnimals.get(i).getSecond());
            }
        }
    }
}
