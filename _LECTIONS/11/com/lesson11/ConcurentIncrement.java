package com.lesson11;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurentIncrement {


    static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    integer.incrementAndGet();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    integer.incrementAndGet();
                }
            }
        };

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println(integer.intValue());

    }

}
