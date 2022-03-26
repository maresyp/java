package com.maresyp;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket clientSocket;

    public void startConnection(String ipv4, int port) throws IOException {
        clientSocket = new Socket(ipv4, port);

    }

    public void sendNotification(String notification, int returnTime) {

    }

    public void stopConnection() throws IOException {
        clientSocket.close();
    }
}
