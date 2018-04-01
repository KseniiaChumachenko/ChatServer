package ChatServer.Interfaces;

import ChatServer.ChatMessage;

public interface Observer {
    void update(ChatMessage chatMessage);
}
