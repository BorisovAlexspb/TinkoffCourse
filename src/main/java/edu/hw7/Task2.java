package edu.hw7;

import java.util.stream.LongStream;

public class Task2 {

    private Task2() {

    }

    public static Long getFactorial(int n) {
        return LongStream.range(1, n).parallel().reduce((a, b) -> a * b).getAsLong();
    }

}
