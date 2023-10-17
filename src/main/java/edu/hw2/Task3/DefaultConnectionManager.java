package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager {
    final int numbStableConnection = 3;
    final int numberForRndMethod = 6;

    public String getSometimesFaultyConnection() {
        Random rnd = new Random();
        if (rnd.nextInt(numberForRndMethod) == numbStableConnection) {
            return "FaultyConnection";
        }
        return "StableConnection";
    }
}
