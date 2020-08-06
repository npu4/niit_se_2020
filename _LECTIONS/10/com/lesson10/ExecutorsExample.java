package com.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                final Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            final Future<Integer> task = service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    final int toSleep = new Random().nextInt(1000);
                    Thread.sleep(toSleep);
                    return toSleep;
                }
            });

            results.add(task);
        }


        int sum = 0;


        for (Future<Integer> result : results) {
            sum += result.get();
        }

        System.out.println(sum);


    }
}
