package com.lesson10;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Random;

public class UncaughtException {


    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {

               /* try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if (new Random().nextBoolean()) {
                    throw new RuntimeException("не повезло");
                }
                System.out.println("Все хорошо");
            }
        };

        t.setName("Поток на удачу");
        t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(String.format("В потоке %s случилось исключение %s", t.getName(), e.getMessage()));
            }
        });
        t.setDaemon(true);
        t.start();

        System.out.println("Конец main");
    }
}
