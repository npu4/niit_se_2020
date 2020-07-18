package calculator;

import java.util.Random;

public class Square extends Figure {
    private int length;

    public Square() {
        length = new Random().nextInt(10) + 1;
    }

    @Override
    double square() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Square - " +
                "square=" + square();
    }
}
