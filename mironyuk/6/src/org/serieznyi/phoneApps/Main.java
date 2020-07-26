package org.serieznyi.phoneApps;

import org.serieznyi.tuple.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    List<Triple<String, Integer, Double>> rating = new ArrayList<>();

    rating.add(Triple.fromArgs("Вконтакте", 25000, 4.4));
    rating.add(Triple.fromArgs("Одноклассники", 13000, 3.3));
    rating.add(Triple.fromArgs("Компас", 234, 1.3));
    rating.add(Triple.fromArgs("2GIS", 33000, 4.5));

    showSortedByScoreCount(rating);

    System.out.println();

    showAppWithBestRating(rating);

    System.out.println();

    showAppWithWorstRating(rating);
  }

  private static void showSortedByScoreCount(final List<Triple<String, Integer, Double>> rating) {
    System.out.println("Сортируем по количеству оценок");

    rating.stream()
        .sorted(Comparator.comparingDouble(Triple::getSecond))
        .forEach(
            (t) -> System.out.printf("%s, %s, %s\n", t.getFirst(), t.getSecond(), t.getThird()));
  }

  private static void showAppWithBestRating(final List<Triple<String, Integer, Double>> rating) {
    Optional<Triple<String, Integer, Double>> max =
        rating.stream().max(Comparator.comparingDouble(Triple::getThird));

    if (!max.isPresent()) {
      System.out.println("Приложение с лучшим рейтингом не найдено");

      return;
    }

    Triple<String, Integer, Double> appWithBestRating = max.get();

    System.out.printf(
        "Приложение с лучшим рейтингом: %s (%s)\n",
        appWithBestRating.getFirst(), appWithBestRating.getThird());
  }

  private static void showAppWithWorstRating(final List<Triple<String, Integer, Double>> rating) {
    Optional<Triple<String, Integer, Double>> min =
        rating.stream().min(Comparator.comparingDouble(Triple::getThird));

    if (!min.isPresent()) {
      System.out.println("Приложение с худшим рейтингом не найдено");

      return;
    }

    Triple<String, Integer, Double> appWithWorstRating = min.get();

    System.out.printf(
        "Приложение с худшим рейтингом: %s (%s)\n",
        appWithWorstRating.getFirst(), appWithWorstRating.getThird());
  }
}
