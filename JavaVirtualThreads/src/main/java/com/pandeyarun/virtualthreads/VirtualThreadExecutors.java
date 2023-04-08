package com.pandeyarun.virtualthreads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class VirtualThreadExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String resultUsingPlatformThreads = useExecutorWithPlatformThreads("Platform threads", Executors.newFixedThreadPool(100));
        String resultUsingVirtualThreads = useExecutorWithPlatformThreads("Virtual threads", Executors.newVirtualThreadPerTaskExecutor());
        System.out.println();
        System.out.println(resultUsingPlatformThreads);
        System.out.println(resultUsingVirtualThreads);

    }

    private static String useExecutorWithPlatformThreads(String executorType, ExecutorService executor) throws InterruptedException, ExecutionException {
        List<Task> tasks = new ArrayList<>();
        IntStream.range(0, 1_000).forEach(i -> tasks.add(new Task(i)));

        Instant start = Instant.now();
        List<Future<Integer>> futures = executor.invokeAll(tasks);

        long sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }

        long duration = Duration.between(start, Instant.now()).toMillis();
        String result = String.format("Using %s sum = %d; time = %d milliseconds", executorType, sum, duration);

        executor.shutdown();
        return result;
    }


}
