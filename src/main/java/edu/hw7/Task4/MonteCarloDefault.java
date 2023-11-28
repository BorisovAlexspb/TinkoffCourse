package edu.hw7.Task4;

public abstract class MonteCarloDefault {

    protected final static int RADIUS = 1;
    protected final static int THREAD_NUMBER = 4;
    protected final static long NUMBER_OF_ITERATION = 100_000;
    protected final static int SCALE = 4;

    public boolean checkIfInCircle(double x, double y) {
        return x * x + y * y <= RADIUS * RADIUS;
    }

    public abstract double getPi();

    public abstract double count();
}
