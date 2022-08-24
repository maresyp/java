package com.maresyp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public void start(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while(true) {
                Socket socket = serverSocket.accept();
                new ConnectionHandler(socket).start();
            }
        } catch (Exception exception) {
            System.out.println("Error occured while accepting new connection. " + Arrays.toString(exception.getStackTrace()));
        }
    }


    private static class ConnectionHandler extends Thread {
        private final Socket clientSocket;

        public ConnectionHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                while (true) {
                    int timeout = Integer.parseInt(input.readLine()) * 1000;
                    String message = input.readLine();
                    if (message == null) {
                        break;
                    }
                    System.out.println("Server got [" + timeout / 1000 + "s] " + message);
                    Thread.sleep(timeout);
                    output.println(message);
                }
            } catch (Exception exception) {
                System.out.println("Error occured in ConnectionHandler " + Arrays.toString(exception.getStackTrace()));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // create server object
        Server server = new Server();
        server.start(6666);
    }
}
