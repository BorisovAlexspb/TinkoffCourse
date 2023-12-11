package edu.hw7.Task4;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    MonteCarloCounterMultiThread multiThread;
    MonteCarloCounterOneThread singleThread;

    @BeforeEach
    void setup() throws InterruptedException {
        multiThread = new MonteCarloCounterMultiThread();
        singleThread = new MonteCarloCounterOneThread();
    }

    @Test
    @DisplayName("approximatePi test")
    public void approximatePi_shouldReturnValueClosedToPi() {
        assertThat(singleThread.getPi()).isCloseTo(Math.PI, Offset.offset(0.01));
    }

    @Test
    @DisplayName("approximatePiParallel test")
    public void approximatePiParallel_shouldReturnValueClosedToPi() {
        assertThat(multiThread.getPi()).isCloseTo(Math.PI, Offset.offset(0.01));
    }
}
