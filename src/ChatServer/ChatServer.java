package ChatServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ChatServer open socket and accept connection then open chatConsole
 */

public class ChatServer {

    ServerSocket serverSocket = null;
    Socket clientSocket = null;

    public void serve() {

        try {
            InetAddress IP = InetAddress.getLocalHost();
            System.out.println("IP: " + IP.getHostAddress());
            serverSocket = new ServerSocket(0, 1);
            System.out.println("Port: " + serverSocket.getLocalPort());
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
        } catch (IOException e) {
            System.out.println("Could not listen on port.");
            e.printStackTrace();
            return;
        }

        ChatConsole chatWindow = new ChatConsole();
        chatWindow.open(clientSocket);

    }
}
