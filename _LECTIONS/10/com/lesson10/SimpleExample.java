package com.lesson10;

public class SimpleExample {


    public static void main(String[] args) {
        final Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("А");
                }
            }
        });
        a.start();


        final Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("1");
                }
            }
        };
        thread.start();
    }
}
