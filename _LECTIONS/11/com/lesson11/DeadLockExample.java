package com.lesson11;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    static ReentrantLock oneMonitor = new ReentrantLock();
    static ReentrantLock anotherMonitor = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        final LockAnotherThenOneThread firstThread = new LockAnotherThenOneThread();
        firstThread.start();
        final LockOneThenAnotherThread secndThread = new LockOneThenAnotherThread();
        secndThread.start();
        System.out.println("Конец main");
    }

    static class LockOneThenAnotherThread extends Thread{
        @Override
        public void run() {

            oneMonitor.lock();
            {
                System.out.println("Поток 1:Один монитор захвачен");
                try {
                    Thread.sleep(1000);
                    /*if (anotherMonitor.isLocked()) {
                        System.out.println("Другой монитор, ничего не делаем.");
                        anotherMonitor.unlock();
                        return;
                    }*/

                    if (anotherMonitor.tryLock(5, TimeUnit.SECONDS)) {
                        System.out.println("Оба монитора захвачены");
                    } else {
                        System.out.println("Не удалось захватить монитор за 5 секунд");
                    }

                    anotherMonitor.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            oneMonitor.unlock();

        }
    }



    static class LockAnotherThenOneThread extends Thread{
        @Override
        public void run() {

            anotherMonitor.lock();
            {
                System.out.println("Поток 2:Один монитор захвачен");
                try {
                    Thread.sleep(1000);
                    oneMonitor.lock();
                    {
                        System.out.println("Оба монитора захвачены");
                    }
                    oneMonitor.unlock();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            anotherMonitor.unlock();


        }
    }





}
