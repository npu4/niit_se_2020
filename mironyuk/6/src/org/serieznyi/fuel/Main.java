package org.serieznyi.fuel;

import org.serieznyi.tuple.Triple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    List<Triple<String, GasolineType, Double>> fuelPrices = new ArrayList<>();

    fuelPrices.add(Triple.fromArgs("Пушкина, 12", GasolineType.DIESEL_FUEL, 12.0));
    fuelPrices.add(Triple.fromArgs("Гагарина, 32a", GasolineType.DIESEL_FUEL, 14.0));
    fuelPrices.add(Triple.fromArgs("Горького, 5a", GasolineType.OCTANE_RATE_92, 22.0));
    fuelPrices.add(Triple.fromArgs("Гоголя, 25/1", GasolineType.OCTANE_RATE_95, 29.0));
    fuelPrices.add(Triple.fromArgs("Зевса, 1", GasolineType.OCTANE_RATE_95, 31.0));
    fuelPrices.add(Triple.fromArgs("Шевченка, 53", GasolineType.OCTANE_RATE_98, 36.0));

    findBestPrice(fuelPrices, GasolineType.OCTANE_RATE_95);
    findBestPrice(fuelPrices, GasolineType.DIESEL_FUEL);
    findBestPrice(fuelPrices, GasolineType.OCTANE_RATE_98);
  }

  private static void findBestPrice(
      final List<Triple<String, GasolineType, Double>> fuelPrices, GasolineType type) {
    Optional<Triple<String, GasolineType, Double>> bestPriceOptional =
        fuelPrices.stream()
            .filter((t) -> t.getSecond() == type)
            .min(
                (t1, t2) -> {
                  double p1 = t1.getThird();
                  double p2 = t2.getThird();

                  if (p1 == p2) {
                    return 0;
                  }

                  return p1 > p2 ? 1 : -1;
                });

    if (!bestPriceOptional.isPresent()) {
      System.out.println(String.format("Лучшая цена для %s не найдена", type));
      return;
    }

    Triple<String, GasolineType, Double> bestPrice = bestPriceOptional.get();
    System.out.println(
        String.format(
            "Лучшая цена для %s находится по адресу \"%s\" и стоит %s",
            type, bestPrice.getFirst(), bestPrice.getThird()));
  }
}
