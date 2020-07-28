package org.serieznyi.shop.fabric;

import org.serieznyi.shop.item.food.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class AppleGarden {
    private int counter = 1;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public void fillShopWithApples(Collection<? super Apple> shop)
    {
        Collection<Apple> apples = generateApples();

        shop.addAll(apples);

        System.out.println(format(
                "В магазин добавлены яблоки: %s",
                Arrays.toString(apples.stream().map(Apple::getColor).toArray(Apple.Color[]::new))
        ));
    }

    private Collection<Apple> generateApples() {
        Collection<Apple> apples = new ArrayList<>();

        for (int i = 0 ; i < random.nextInt(2, 10) ; i++) {
            apples.add(makeApple());
        }

        return apples;
    }

    private Apple makeApple()
    {
        return new Apple(
                "Яблоко №" + counter++,
                random.nextInt(10, 50),
                random.nextInt(10, 40),
                random.nextInt(5, 10),
                nextAppleColor()
        );
    }

    private Apple.Color nextAppleColor()
    {
        Apple.Color[] colors = Apple.Color.values();

        return colors[random.nextInt(0, colors.length)];
    }
}
