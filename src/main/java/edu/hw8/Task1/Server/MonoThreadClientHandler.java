package edu.hw8.Task1.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

@SuppressWarnings("InnerAssignment")
public class MonoThreadClientHandler implements Runnable {

    private static Socket client;

    public MonoThreadClientHandler(Socket client) {
        MonoThreadClientHandler.client = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

           // System.out.println("Server reading from channel");

            String inputMessage = in.readUTF();

            String backMessage;
            switch (inputMessage) {
                case "личности" -> backMessage = "Не переходи на личности там, где их нет";
                case "оскорбления" -> backMessage =
                    "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами";
                case "глупый" -> backMessage =
                    "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма";
                case "интеллект" -> backMessage = "Чем ниже интеллект, тем громче оскорбления";
                default -> backMessage = "Что ты сказал? Повтори";
            }
            out.writeUTF(backMessage);
            out.flush();

            in.close();
            out.close();
            client.close();

        } catch (IOException e) {
            e.getMessage();
        }

    }

}
