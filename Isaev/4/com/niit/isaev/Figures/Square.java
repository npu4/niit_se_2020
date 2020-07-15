package com.niit.isaev.Figures;

public class Square extends Figure {

    int sideLength = 1 + random.nextInt(10);

    @Override
    double square() {
        return sideLength * sideLength;
    }

}
