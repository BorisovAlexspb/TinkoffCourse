package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloCounterMultiThread extends MonteCarloDefault {

    private double sum = 0.0;
    ExecutorService executorService;

    MonteCarloCounterMultiThread() throws InterruptedException {
        executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
        run();
    }

    @Override
    public double count() {
        long circleCount = 0;
        for (int i = 0; i < NUMBER_OF_ITERATION / THREAD_NUMBER; i++) {
            if (checkIfInCircle(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble())) {
                circleCount++;
            }
        }
        return circleCount;
    }

    public void run() throws InterruptedException {
        List<Future<Double>> futures = new ArrayList<>();

        for (int i = 0; i < THREAD_NUMBER; i++) {
            futures.add(executorService.submit(this::count));
        }

        for (var future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
        executorService.shutdown();
    }

    @Override
    public double getPi() {
        return SCALE * (sum / NUMBER_OF_ITERATION);
    }

}
