package edu.hw8.Task1.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"checkstyle:MagicNumber", "RegexpSinglelineJava"})
public class MultiClients implements Runnable {

    private static final String HOST = "localhost";
    private static final int PORT = 3345;
    private final String message;
    private static Socket socket;
    public static List<String> inMessageList = new ArrayList<>();

    public MultiClients(String message) {
        this.message = message;
        try {
            socket = new Socket(HOST, PORT);
            //System.out.println("Client connected to socket");

        } catch (Exception e) {
            throw new RuntimeException("Client did not connect to socket");
        }
    }

    @Override
    public void run() {
        try (
            DataOutputStream outMessage = new DataOutputStream(socket.getOutputStream());
            DataInputStream inMessage = new DataInputStream(socket.getInputStream());
        ) {

            outMessage.writeUTF(message);

            outMessage.flush();

            String messageFromServer = inMessage.readUTF();
            System.out.println(message + " : " + messageFromServer);

            inMessageList.add(messageFromServer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<String> getInMessageList() {
        return inMessageList;
    }

}
