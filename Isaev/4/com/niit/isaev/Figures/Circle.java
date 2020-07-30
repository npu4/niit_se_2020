package com.niit.isaev.Figures;

public class Circle extends Figure {

    int radius = 1 + random.nextInt(10);

    @Override
    double square() {
        return 3.14 * (radius * radius);
    }

}
