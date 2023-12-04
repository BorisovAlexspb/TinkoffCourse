package edu.hw8.Task1;

import edu.hw8.Task1.Server.MonoThreadClientHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTest {

    static ExecutorService executeIt = Executors.newFixedThreadPool(2);
    private final int PORT;
    private static final int NUMBER_OF_THREADS = 10;

    public ServerTest (int PORT){
        this.PORT = PORT;
    }

    public void runServer() {

        try (ServerSocket server = new ServerSocket(PORT)) {
            //System.out.println("Server socket created, command console reader for listen to server commands");
            server.setSoTimeout(5000);
            int count = 0;

            while (!server.isClosed()) {
                count++;
                if (count > NUMBER_OF_THREADS + 1) {
                    server.close();
                    break;
                }

                Socket client = server.accept();

                executeIt.execute(new MonoThreadClientHandler(client));
                //System.out.println("Connection accepted");
            }

            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

