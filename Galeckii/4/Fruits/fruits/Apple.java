package fruits;

import java.util.Random;

public class Apple extends Fruit {
    private final String[] COLORS = {"Red", "Green", "Yellow"};
    private final String color;

    public Apple(int weight) {
        this.color = COLORS[new Random().nextInt(COLORS.length)];
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
