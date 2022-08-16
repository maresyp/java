package com.maresyp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            new ConnectionHandler(serverSocket.accept()).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class ConnectionHandler extends Thread {
        private final Socket clientSocket;

        public ConnectionHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream input = new DataInputStream(this.clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(this.clientSocket.getOutputStream());
                // get data from client
                int timeout = input.readInt();
                String message = input.readUTF();
                System.out.println("Server received message : " + message + " with : " + timeout + " timeout.");

                // send data back
                Thread.sleep(timeout);
                outputStream.writeUTF(message);
            } catch (IOException e) {
                System.out.println(e);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // create server object
        Server server = new Server();
        try {
            server.start(6666);
        } finally {
            server.stop();
        }
    }
}
