package calculator;

import java.util.Random;

public class Circle extends Figure {
    private int radius;

    @Override
    double square() {
        return Math.PI * radius * radius;
    }

    public Circle() {
        radius = new Random().nextInt(10) + 1;
    }

    @Override
    public String toString() {
        return "Circle - " +
                "square=" + String.format("%.2f", square());
    }
}
