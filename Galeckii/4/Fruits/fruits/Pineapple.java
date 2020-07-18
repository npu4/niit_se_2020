package fruits;

import java.util.Random;

public class Pineapple extends Fruit {
    private int tailLength;

    public Pineapple(int weight) {
        this.weight = weight;
        tailLength = new Random().nextInt(21)+5;
    }

    @Override
    public String toString() {
        return "Pineapple{" +
                "tailLength=" + tailLength +
                ", weight=" + weight +
                '}';
    }
}
