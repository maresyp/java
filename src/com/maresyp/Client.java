package com.maresyp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void startConnection(String ipv4, int port) {
        try (Socket socket = new Socket(ipv4, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
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

                    output.println(timeout);
                    output.println(message);

                    String response = input.readLine();
                    System.out.println("Response -> " + response);

                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Please try again...");
                }
            }
        } catch (Exception exception) {
            System.out.println("Error occured in client");
        }
    }
    public static void main(String[] args) {
        // create client
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
    }
}
