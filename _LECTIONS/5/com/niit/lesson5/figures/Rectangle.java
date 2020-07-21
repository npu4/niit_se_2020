package com.niit.lesson5.figures;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }


    @Override
    int square() {
        return width * height;
    }
}
