package edu.hw8.Task1;

import edu.hw8.Task1.Client.MultiClients;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RunnerTask1Test {

    @Test
    @DisplayName("different value of PORT")
    public void task1TestShouldReturnException() throws IOException, InterruptedException {
        ServerTest server = new ServerTest(8080);
        Thread serverThread = new Thread(server::runServer);
        Throwable exception = assertThrows(RuntimeException.class, () -> new ClientTest().runClient());
        assertEquals("Client did not connect to socket", exception.getMessage());
    }

    @Test
    @DisplayName("get message from clients in one list")
    public void testClientShouldReturnListOfAnswers() throws InterruptedException, IOException {
        ServerTest server = new ServerTest(3345);
        Thread serverThread = new Thread(server::runServer);
        serverThread.start();
        Thread.sleep(2000);
        ClientTest clients = new ClientTest();
        clients.runClient();
        Assertions.assertThat(new MultiClients("any message").getInMessageList()).isNotEmpty();

        //firstClient.close();
        Thread.sleep(2000);
        serverThread.join();
    }

}
