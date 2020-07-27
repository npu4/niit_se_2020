package com.lesson7;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriotiyBlockingQueueSample {


    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new PriorityBlockingQueue<>(5, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        queue.offer("Вася");
        queue.offer("Влад");
        queue.offer("Антон");
        queue.offer("Яна");
        queue.offer("Владислав");


        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println("Ждем 3 секунды");
        final String poll = queue.poll(3, TimeUnit.SECONDS);
        System.out.println(poll);
        System.out.println("Подождали  3 секунды");


    }
}
