package edu.hw8.Task1.Client;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"HideUtilityClassConstructor", "UncommentedMain"})
public class StartClient {

    private final static String[] TYPE_OF_MESSAGE = {"личности", "оскорбления", "глупый", "интеллект"};
    private static final int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) throws IOException, InterruptedException {
        Random rnd = new Random();

        ExecutorService exec = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        int j = 0;

        while (j < NUMBER_OF_THREADS) {
            String message = TYPE_OF_MESSAGE[rnd.nextInt(TYPE_OF_MESSAGE.length - 1)];

            exec.execute(new MultiClients(message));
            j++;
        }

        exec.shutdown();
    }
}
