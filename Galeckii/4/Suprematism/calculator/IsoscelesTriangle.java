package calculator;

import java.util.Random;

public class IsoscelesTriangle extends Figure {
    private int height;
    private int base;

    public IsoscelesTriangle() {
        height = new Random().nextInt(10) + 1;
        base = new Random().nextInt(10) + 1;
    }

    @Override
    double square() {
        return height * base / 2.0;
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle - " +
                "square=" + square();
    }
}
