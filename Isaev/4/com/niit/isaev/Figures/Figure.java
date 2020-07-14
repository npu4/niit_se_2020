package com.niit.isaev.Figures;

public class Figure {

    int x;
    int y;


    void square(){

    }

    int getQuadrant(){

        if(x>0 && y>0){
            return 1;
        } else if (x>0 && y<0){
            return 4;
        } else if (x<0 && y>0){
            return 2;
        } else {
            return 3;
        }

    }

}
