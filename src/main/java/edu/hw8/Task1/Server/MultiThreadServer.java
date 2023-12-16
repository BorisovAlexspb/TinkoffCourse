package edu.hw8.Task1.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"HideUtilityClassConstructor", "UncommentedMain", "MagicNumber"})
public class MultiThreadServer {

    static ExecutorService executeIt = Executors.newFixedThreadPool(4);
    private static final int PORT = 3345;
    private static final int WAITING_TIME = 3000;
    ServerSocket server;

    public void start() {

        try {
            server = new ServerSocket(PORT);
            server.setSoTimeout(WAITING_TIME);
            Thread.sleep(2000);
            while (true) {
                executeIt.execute(new MonoThreadClientHandler(server.accept()));
            }

        } catch (SocketTimeoutException e) {
            close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void close() {
        executeIt.shutdown();
        try {
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
