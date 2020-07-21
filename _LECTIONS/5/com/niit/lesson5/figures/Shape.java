package com.niit.lesson5.figures;

public abstract class Shape {
    private int x;
    private int y;


    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract int square();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
