package com.lesson10;

public class ProfilerSample {


    public static void main(String[] args) {


        Thread t1 = new Thread() {
            @Override
            public void run() {
                long current = 0;
                while (current < 1_000_000_000) {
                    current++;
                    System.out.println("Working hard:" + current);
                }
                ;
            }
        };


        Thread t2 = new Thread() {
            @Override
            public void run() {
                long current = 0;
                while (current < 1_000_000_000) {
                    current++;
                    System.out.println("Working hardly:" + current);

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ;
            }
        };


        t1.setName("Работяга");
        t2.setName("Лентяй");
        t2.start();
        t1.start();



    }
}
