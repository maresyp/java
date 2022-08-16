package com.maresyp;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    public void startConnection(String ipv4, int port) throws IOException {
        clientSocket = new Socket(ipv4, port);
    }

    public void sendNotification(String notification, int returnTime) throws IOException {
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());

        output.writeInt(returnTime * 1000);
        output.flush();
        output.writeUTF(notification);
        output.flush();

        // Message received back from server
        System.out.println(inputStream.readUTF());
    }

    public void stopConnection() throws IOException {
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        // create client
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        client.sendNotification("Test message", 5);
        client.stopConnection();
    }
}
