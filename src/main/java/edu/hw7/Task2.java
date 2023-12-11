package edu.hw7;

import java.util.stream.LongStream;

public class Task2 {

    private Task2() {

    }

    public static Long getFactorial(int n) {
        if (n < 0) {
            throw new RuntimeException("Wrong number");
        }
        return LongStream.range(1, n + 1).parallel().reduce((a, b) -> a * b).getAsLong();
    }

}
