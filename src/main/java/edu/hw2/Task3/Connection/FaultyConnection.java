package edu.hw2.Task3.Connection;

import edu.hw2.Task3.Exception.ConnectionIsNotStableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private final double probability = 0.5;

    @Override
    public void execute(String command) {
        if (Math.random() < probability) {
            throw new ConnectionIsNotStableException("Faulty Connection");
        }
        LOGGER.info("> Command " + command + " is completed!");
    }

    @Override
    public void close() throws Exception {

    }
}
