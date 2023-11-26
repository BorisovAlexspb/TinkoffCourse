package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    private final AtomicInteger value = new AtomicInteger(0);

    public void plusOne() {
        value.addAndGet(1);
    }

    public int getValue() {
        return value.get();
    }

}
