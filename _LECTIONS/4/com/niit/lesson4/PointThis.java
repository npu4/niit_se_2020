package com.niit.lesson4;

public class PointThis {


    static class Point {
        int x;
        int y;


        public Point() {
            this(0, 0);
            System.out.println("Конструктор без параметров");
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Point p = new Point();
    }
}
