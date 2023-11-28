package edu.hw7.Task4;

import java.util.Random;

public class MonteCarloCounterOneThread extends MonteCarloDefault {

    private long circleCount;
    Random rnd = new Random();

    @Override
    public double count() {
        for (int i = 0; i < NUMBER_OF_ITERATION; i++) {
            if (checkIfInCircle(rnd.nextDouble() * 2 - 1, rnd.nextDouble() * 2 - 1)) {
                circleCount++;
            }
        }
        return circleCount;
    }

    @Override
    public double getPi() {
        count();
        return SCALE * ((double) circleCount / NUMBER_OF_ITERATION);
    }
}
