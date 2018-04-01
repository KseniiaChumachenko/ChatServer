package ChatServer;

/*
 *Thing that makes everything alive
 */

public class Main {

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.serve();
    }
}
