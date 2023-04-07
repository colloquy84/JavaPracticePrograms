package com.pandeyarun.virtualthreads;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        Runnable runnable = () -> {
            double i = random.nextDouble(1000) % random.nextDouble(1000);
        };
        useSystemThreads(runnable, 50_000);
        useVirtualThreads(runnable,1_000_000);
    }

    private static void useVirtualThreads(Runnable runnable, int iterations) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            Thread.startVirtualThread(runnable);
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.printf("%s iterations with system virtual, time taken: %s milliseconds%n", iterations, timeElapsed);
    }

    private static void useSystemThreads(Runnable runnable, int iterations) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.printf("%s iterations with system threads, time taken: %s milliseconds%n", iterations, timeElapsed);
    }
}
