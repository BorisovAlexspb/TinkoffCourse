package edu.hw2.Task3;

import java.io.IOException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private final static Logger LOGGER = LogManager.getLogger();

    public void startConnection() throws IOException {
        Random rnd = new Random();
        PopularCommandExecutor pce = new PopularCommandExecutor();
        FaultyConnectionManager fcm = new FaultyConnectionManager();
        DefaultConnectionManager dcm = new DefaultConnectionManager();

        int countOfFaultyAttempts = 0;
        final int numbStableConnection = 3;
        final int maxFaultyAttempts = pce.getmaxAttempts();
        final int numberForRandomMethod = 6;
        pce.close();

        while (countOfFaultyAttempts < maxFaultyAttempts) {
            try (PopularCommandExecutor PCE = new PopularCommandExecutor()) {
                String typeOfConnection = "";
                if (rnd.nextInt(numberForRandomMethod) == numbStableConnection) {
                    typeOfConnection = fcm.getAlwaysFaultyConnection();
                } else {
                    typeOfConnection = dcm.getSometimesFaultyConnection();
                }
                PCE.updatePackages(typeOfConnection);
                if (!PCE.getConnection()) {
                    countOfFaultyAttempts++;
                    if (countOfFaultyAttempts == maxFaultyAttempts) {
                        LOGGER.info("original Exception: " + PCE.getCause());
                        //System.out.println("original Exception: " + PCE.getCause());
                    }

                }
            }
        }
    }
}
