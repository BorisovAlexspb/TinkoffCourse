package edu.hw8.Task1.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"InnerAssignment", "MagicNumber"})
public class MonoThreadClientHandler implements Runnable {

    private final Socket client;
    private final static Map<String, String> ANSWERS = new HashMap<>(Map.of(
        "личности", "Не переходи на личности там, где их нет",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления"
    ));

    public MonoThreadClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            // System.out.println("Server reading from channel");

            while (!client.isClosed()) {
                String inputMessage;
                try {
                    inputMessage = in.readUTF();
                } catch (IOException e) {
                    break;
                }

                out.writeUTF(handleMessage(inputMessage));
                out.flush();
                Thread.sleep(10);
            }
            in.close();
            out.close();
            client.close();

        } catch (IOException | InterruptedException e) {
            e.getMessage();
        }

    }

    private String handleMessage(String clientMessage) {
        return ANSWERS.getOrDefault(clientMessage, "Что ты сказал? Повтори");
    }
}
