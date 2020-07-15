package com.niit.isaev.Figures;

import java.util.Random;

public class mainFigure {

    public static void main(String[] args) {
        Random random = new Random();

        Figure[] figures = new Figure[5];
        for(int i=0;i<figures.length;i++){
            figures[i] = randomFigure(random.nextInt(3));
        }

        for (Figure figure:figures){
            System.out.println(figure.getName() + " - "+figure.square());
        }


    }

    static Figure randomFigure(int number){
        return switch (number) {
            case 0 -> new Circle();
            case 1 -> new IsoscelesTriangle();
            case 2 -> new Square();
            default -> null;
        };
    }

}
