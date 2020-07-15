package com.niit.isaev.Figures;

import java.util.Random;

public class Figure {

    Random random = new Random();

    int x = - 50 + random.nextInt(101);
    int y = - 50 + random.nextInt(101);

    int getQuadrant(){

        if(x>0 && y>0){
            return 1;
        } else if (x>0 && y<0){
            return 4;
        } else if (x<0 && y>0){
            return 2;
        } else if(x<0 && y<0){
            return 3;
        } else {
            return 01;
        }

    }

    double square(){
        return 0;
    }

    String getName(){
        return this.getClass().getSimpleName();
    }

}
