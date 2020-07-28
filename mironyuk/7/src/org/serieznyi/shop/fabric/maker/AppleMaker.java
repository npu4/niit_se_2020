package org.serieznyi.shop.fabric.maker;

import org.serieznyi.shop.item.food.Apple;

import java.util.concurrent.ThreadLocalRandom;

public class AppleMaker {
    private int counter = 1;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Apple make()
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
