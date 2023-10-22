package edu.hw2.Task3.Manager;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.Connection.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    Random rnd = new Random();
    private final double probability;

    public DefaultConnectionManager(double probability) {
        this.probability = probability;
    }

    @Override
    public Connection getConnection() {
        if (Math.random() < probability) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}

