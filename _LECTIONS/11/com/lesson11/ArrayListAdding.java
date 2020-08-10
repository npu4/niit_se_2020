package com.lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListAdding {


    static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    list.add(i);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {

                while (list.isEmpty()) {

                }


                for (Integer integer : list) {
                    System.out.println(integer);
                }


                super.run();
            }
        };

        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println(list.size());

    }

}
