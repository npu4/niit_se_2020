package com.lesson10;

import java.util.Arrays;
import java.util.List;

public class ThreadExecutor extends Thread {


    final List<Runnable> toExecute;


    public ThreadExecutor(List<Runnable> toExecute) {
        this.toExecute = toExecute;
    }


    @Override
    public void run() {
        for (Runnable runnable : toExecute) {
            runnable.run();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable longTask = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Долгая работа начата");
                    waitTime(1000);
                    System.out.println("Долгая работа завершена");
                } catch (InterruptedException e) {
                    System.out.println("Долгая работа не завершена");
                }

            }
        };

        Runnable veryLongTask = new Runnable() {
            @Override
            public void run() {
                try {

                    System.out.println("Очень долгая работа начата");
                    waitTime(2000);
                    System.out.println("Очень Долгая работа завершена");
                } catch (InterruptedException e) {
                    System.out.println("Очень Долгая работа не завершена");

                }
            }
        };

        ThreadExecutor executor = new ThreadExecutor(Arrays.asList(longTask, veryLongTask));
        executor.start();


        Thread.sleep(100);
        executor.interrupt();
        System.out.println("Конец main");
    }



    public static void waitTime(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }
}


