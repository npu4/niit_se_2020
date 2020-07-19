package fruits;

import java.util.Random;

public class Orange extends Fruit {
    private int thickness;

    public Orange(int weight) {
        this.weight = weight;
        this.thickness = new Random().nextInt(21);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "thickness=" + thickness +
                ", weight=" + weight +
                '}';
    }
}
