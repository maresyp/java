package com.maresyp;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
        while (true) {
            System.out.println("Select an option");
            System.out.println("[1] Send message");
            System.out.println("[2] Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Type timeout in seconds..");
                int timeout = Integer.parseInt(scanner.nextLine());
                System.out.println("Type your message..");
                String message = scanner.nextLine();

                client.sendNotification(message, timeout);
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Please try again...");
            }
        }
        client.stopConnection();
    }
}
