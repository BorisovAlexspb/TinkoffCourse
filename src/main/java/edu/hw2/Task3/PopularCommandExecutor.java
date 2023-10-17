package edu.hw2.Task3;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor implements Connection, ConnectionManager {
    //private final ConnectionManager manager;
    private final static Logger LOGGER = LogManager.getLogger();
    ConnectionException exp;
    private final int maxAttempts = 5;
    private boolean check = true;
    private RuntimeException cause;

    public void updatePackages(String typeOfConnection) {
        tryExecute(typeOfConnection);
    }

    void tryExecute(String command) {
        if (command.equals("StableConnection")) {
            execute();
            check = true;
        } else {
            try {
                exp.getException();
            } catch (RuntimeException e) {
                //System.out.println("error - Runtime Exception");
                LOGGER.info("error - Runtime Exception");
                cause = e;
            } finally {
                check = false;
            }
        }
    }

    public void execute() {
        //System.out.println("Connection is stable");
        LOGGER.info("Connection is stable");
    }

    public boolean getConnection() {
        return check;
    }

    public int getmaxAttempts() {
        return maxAttempts;
    }

    public RuntimeException getCause() {
        return cause;
    }

    @Override
    public void close() throws IOException {
    }
}
