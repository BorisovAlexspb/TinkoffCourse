package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Increment test")
    public void increment_shouldReturnCorrectValue() throws InterruptedException {
        Task1 task1 = new Task1();

        Thread first = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                task1.value.getAndIncrement();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                task1.value.getAndIncrement();
            }
        });

        first.start();
        second.start();

        if (first.isAlive()) {
            first.join();
        }
        if (second.isAlive()) {
            second.join();
        }

        assertEquals(task1.value.get(), 200_000);
    }

}
