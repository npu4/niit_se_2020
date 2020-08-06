package com.lesson10;

public class SleepExample {


    static int result = -1;

    static Thread counter = new Thread() {

        @Override
        public void run() {
            // do some work
            try {
                Thread.sleep(2000);
                result = 42;
                System.out.println("Результат посчитан!");

            } catch (InterruptedException e) {
                // меня разбудили
            }
        }


    };

    public static void main(String[] args) throws InterruptedException {

        counter.start();
        counter.join();
        System.out.println(result);



    }
}
