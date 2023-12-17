package edu.hw8.Task1.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

@SuppressWarnings({"checkstyle:MagicNumber", "RegexpSinglelineJava"})
public class MultiClients {

    private static final String HOST = "localhost";
    private static final int PORT = 3345;

    private Socket socket;

    public void start() {
        try {
            socket = new Socket(HOST, PORT);

        } catch (Exception e) {
            throw new RuntimeException("Client did not connect to socket");
        }
    }

    public String sendMessage(String message) {
        try {
            DataOutputStream outMessage = new DataOutputStream(socket.getOutputStream());
            DataInputStream inMessage = new DataInputStream(socket.getInputStream());
            outMessage.writeUTF(message);

            outMessage.flush();
            Thread.sleep(10);
            return inMessage.readUTF();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void close() {
        try {
            this.socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
