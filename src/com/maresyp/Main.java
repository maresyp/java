package com.maresyp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // create server object
        Server server = new Server();
        server.start(6666);

        Client client1 = new Client();

        server.stop();
    }
}
