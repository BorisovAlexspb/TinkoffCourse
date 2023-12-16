package edu.hw8;

import edu.hw8.Task2.FibonacciCalculator;
import edu.hw8.Task2.FixedThreadPool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class Task2Test {
    Map<Integer, Integer> fib = new HashMap<>(Map.of(1, 1, 2, 1, 3, 2, 4, 3, 5, 5));

    @Test
    @DisplayName("fixed thread pool test with fibonacci calculator")
    void FibonacciFixedThreadPoolTest() {
        int threads = 8;
        try (FixedThreadPool fixedThreadPool = FixedThreadPool.create(threads)) {
            fixedThreadPool.start();
            for (int i = 1; i < 6; i++) {
                int finalI = i;
                fixedThreadPool.execute(() -> {
                    FibonacciCalculator fibonacciCalculator = new FibonacciCalculator(finalI);
                    fibonacciCalculator.run();
                    Assertions.assertEquals(fibonacciCalculator.result, fib.get(finalI));
                });
            }

        }

    }
}
