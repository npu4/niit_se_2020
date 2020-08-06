package com.lesson10;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulledService {


    public static void main(String[] args) {



        ScheduledExecutorService schedulledExecutorService = Executors.newSingleThreadScheduledExecutor();


        schedulledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Прошло 1000 ms");
            }
        }, 1000, TimeUnit.MILLISECONDS);


        final ScheduledFuture<?> scheduledFuture = schedulledExecutorService.scheduleAtFixedRate(new Runnable() {
            boolean isFirstTick = true;

            @Override
            public void run() {
                if (isFirstTick) {
                    System.out.println("Прошло 1000 ms");
                    isFirstTick = false;
                    return;
                }
                System.out.println("Прошло 3000 ms");
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);

    }
}
