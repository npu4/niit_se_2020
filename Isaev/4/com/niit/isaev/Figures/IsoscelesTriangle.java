package com.niit.isaev.Figures;

public class IsoscelesTriangle extends Figure{

    int height = 1 +  random.nextInt(10);
    int base = 1 + random.nextInt(10);

    @Override
    double square(){
        return 0.5 * base * height;
    }

}
