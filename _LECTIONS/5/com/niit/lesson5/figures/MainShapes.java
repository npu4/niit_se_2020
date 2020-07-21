package com.niit.lesson5.figures;

public class MainShapes {


    public static void main(String[] args) {
        Shape s1 = new Circle(0, 0, 5);


        Shape s2 = new Rectangle(10, 10, 10, 10);


        System.out.println(String.format("Фигура в %s,%s имеет площадь %s", s1.getX(), s1.getY(), s1.square()));
        System.out.println(s2.square());
    }
}
