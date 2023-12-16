package edu.hw8;

import edu.hw8.Task1.Client.MultiClients;
import edu.hw8.Task1.Server.MultiThreadServer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    @DisplayName("one client test")
    void oneClientTest() throws InterruptedException {
        MultiThreadServer server = new MultiThreadServer();
        Thread serverThread = new Thread(server::start);
        serverThread.start();
        //Thread.sleep(2000);
        MultiClients firstClient = new MultiClients();
        firstClient.start();
        Assertions.assertEquals(firstClient.sendMessage("личности"), "Не переходи на личности там, где их нет");
        Assertions.assertEquals(
            firstClient.sendMessage("оскорбления"),
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
        );
        Assertions.assertEquals(
            firstClient.sendMessage("глупый"),
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма"
        );
        Assertions.assertEquals(firstClient.sendMessage("интеллект"), "Чем ниже интеллект, тем громче оскорбления");
        Assertions.assertEquals(firstClient.sendMessage("дурак"), "Что ты сказал? Повтори");
        firstClient.close();
        //Thread.sleep(2000);
        serverThread.join();
    }

    @Test
    @DisplayName("multiple client test")
    void multipleClientTest() throws InterruptedException, ExecutionException {
        MultiThreadServer server = new MultiThreadServer();
        Thread serverThread = new Thread(server::start);
        serverThread.start();
        ExecutorService clientsExecutor = Executors.newFixedThreadPool(4);
        List<Callable<String>> answers = new ArrayList<>(List.of(
            () -> {
                MultiClients client = new MultiClients();
                client.start();
                String answer = client.sendMessage("личности");
                client.close();
                return answer;
            },
            () -> {
                MultiClients client = new MultiClients();
                client.start();
                String answer = client.sendMessage("оскорбления");
                client.close();
                return answer;
            }
        ));
        List<Future<String>> futures = clientsExecutor.invokeAll(answers);
        Assertions.assertEquals(futures.get(0).get(), "Не переходи на личности там, где их нет");
        Assertions.assertEquals(
            futures.get(1).get(),
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
        );
        serverThread.join();
    }
}