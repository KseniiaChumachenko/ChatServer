package ChatServer.Interfaces;

public interface Observable {
    void notifyObservers(String chatMessage);

    void addObserver(Observer observer);
}
