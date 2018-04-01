package ChatServer;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

class Sender {

    public String help = "---LIST OF AVAILABLE COMMANDS:\n:users - Show you the list of users in dialog\n:history - Show your conversation again" +
            "\n:help - Show this instructions again\n:quit -  Leave the dialogue\n---THE END---\n";
    private PrintWriter out;
    private JTextArea chatView;
    private String user = "Server";
    private ChatMessage m = new ChatMessage();
    private CommandInterpreter ci = new CommandInterpreter();
    private UserNameList unl = new UserNameList();

    /**
     * Sender class send a message and perform command if any
     *
     * @param clientSocket  Socket which has been opened for chat
     * @param chatViewParam Chat history text area of chat window
     */
    public Sender(Socket clientSocket, JTextArea chatViewParam) {
        unl.setServerName(user);
        chatView = chatViewParam;

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);                                                    // Print the message on output stream.
        String tmp = m.printMessage(user, message);
        chatView.append(tmp);
        int command = ci.commandCase(message);
        switch (command) {
            case 1:                                                             //Show you the list of users in dialog
                chatView.append("---USERS---\n" + unl.toString() + "\n---THE END---\n");
                break;
            case 2:                                                              //Show this instructions again
                chatView.append(help);
                break;
            case 3:                                                              //No comments
                chatView.append("To quit the program press little cross in the right upper corner.\n");
            case 4:                                                               //Show your conversation again
                chatView.append("---CHAT HISTORY---\n" + ChatHistory.getInstance().toString() + "\n---THE END---\n");
        }
    }
}
