package com.lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListAsQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(5);
        queue.add(3);
        queue.add(1);

        System.out.println("Элемент в начале очереди " + queue.peek());
        System.out.println(queue);

        System.out.println("Удаляем элемент из очереди " + queue.remove());
        System.out.println(queue);

    }
}
