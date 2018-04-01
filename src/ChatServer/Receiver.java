package ChatServer;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Receiver implements Runnable {

    private BufferedReader bufferedReader;
    private JTextArea chatView;
    private String user;
    private ChatMessage m = new ChatMessage();

    /**
     * Receiver class  receive message, read it and split to username and message parts
     *
     * @param clientSocket  Socket which has been opened for chat
     * @param chatViewParam Chat history text area of chat window
     */
    public Receiver(Socket clientSocket, JTextArea chatViewParam) {
        chatView = chatViewParam;

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        String message;

        while (true) {
            try {
                if (bufferedReader.ready()) {
                    message = bufferedReader.readLine();                                     // Read the chat message.
                    String[] split = message.split(":");
                    user = split[0];
                    message = split[1];
                    String tmp = m.printMessage(user, message);                             //format mesg and add to history
                    chatView.append(tmp);

                }
            } catch (IOException ex) {
                System.out.println("Problem in message reading");
                ex.printStackTrace();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }

    }
}
