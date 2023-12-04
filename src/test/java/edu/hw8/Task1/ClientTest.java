package edu.hw8.Task1;

import edu.hw8.Task1.Client.MultiClients;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTest {

    private final static String[] typeOfMessage = {"личности", "оскорбления", "глупый", "интеллект"};
    private static final int NUMBER_OF_THREADS = 10;

    public void runClient() throws IOException, InterruptedException {
        Random rnd = new Random();

        ExecutorService exec = Executors.newFixedThreadPool(10);
        int j = 0;

        while (j < NUMBER_OF_THREADS) {
            String message = typeOfMessage[rnd.nextInt(typeOfMessage.length - 1)];

            exec.execute(new MultiClients(message));
            Thread.sleep(10);
            j++;
        }

        exec.shutdown();
    }
}
