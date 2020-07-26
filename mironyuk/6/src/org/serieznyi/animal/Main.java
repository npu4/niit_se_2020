package org.serieznyi.animal;

import org.serieznyi.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class Main {
  public static void main(String[] args) {
    List<Pair<Animal, String>> animalsAndFood = new ArrayList<>();
    animalsAndFood.add(new Pair<>(new Animal("Пушистик", Animal.Type.CAT), "Морковь"));
    animalsAndFood.add(new Pair<>(new Animal("Цезарь", Animal.Type.DUCK), "Батон"));
    animalsAndFood.add(new Pair<>(new Animal("Лапка", Animal.Type.RABBIT), "Капуста"));

    feedAnimals(animalsAndFood);
  }

  private static void feedAnimals(List<Pair<Animal, String>> animalsAndFood) {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    int luckyAnimalIndex = random.nextInt(0, animalsAndFood.size());

    int index = 0;
    for (Pair<Animal, String> pair : animalsAndFood) {

      if (index == luckyAnimalIndex) {
        System.out.println(
            format(
                "Счастливое животное %s получает двойную порцию %s",
                pair.getFirst().getName(), pair.getSecond()));
      } else {
        System.out.println(
            format(
                "Животное %s с радостью съедает %s", pair.getFirst().getName(), pair.getSecond()));
      }

      index++;
    }
  }
}
