package com.lesson10;

public class WaitNotify {


    static int answer = -1;


    static Object monitor = new Object();

    static Thread counter = new Thread() {
        @Override
        public void run() {
            synchronized (monitor) {
                try {
                    Thread.sleep(2000);
                    answer = 42;
                    monitor.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    public static void main(String[] args) throws InterruptedException {

        counter.start();
        synchronized (monitor) {
            monitor.wait();
        }



        System.out.println("Ответ готов " + answer);
    }
}
