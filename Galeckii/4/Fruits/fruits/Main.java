package fruits;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < 4; i++) {
            fruits[i] = getRandomFruit();
        }

        Arrays.stream(fruits).forEach(System.out::println);
    }

    public static Fruit getRandomFruit() {
        int random = new Random().nextInt(3);
        switch (random){
            case 0:
                return new Apple(new Random().nextInt(1000));
            case 1:
                return new Orange(new Random().nextInt(1000));
            case 2:
                return new Pineapple(new Random().nextInt(1000));
            default:
                return null;
        }
    }
}
