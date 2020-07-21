package com.niit.lesson5.figures;

public class Circle extends Shape {

    private int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }


    @Override
    int square() {
        return (int) Math.PI * r * r;
    }
}
