package edu.hw8.Task1.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings({"HideUtilityClassConstructor", "UncommentedMain"})
public class MultiThreadServer {

    static ExecutorService executeIt = Executors.newFixedThreadPool(2);
    private static final int PORT = 3345;
    private static final int NUMBER_OF_THREADS = 10;
    private static final int WAITING_TIME = 5000;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {
            //System.out.println("Server socket created, command console reader for listen to server commands");
            server.setSoTimeout(WAITING_TIME);
            int count = 0;

            while (!server.isClosed()) {
                count++;
                if (count > NUMBER_OF_THREADS) {
                    server.close();
                    break;
                }

                Socket client = server.accept();

                executeIt.execute(new MonoThreadClientHandler(client));
                //System.out.println("Connection accepted");
            }

            executeIt.shutdown();
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
