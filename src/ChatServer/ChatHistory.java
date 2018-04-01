package ChatServer;

import ChatServer.Interfaces.Observable;
import ChatServer.Interfaces.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ChatHistory implements Observable {

    /*
     *ChatHistory class insert messages to list and could print it(Singleton)
     */

    private static ChatHistory ourInstance = new ChatHistory();
    ArrayList history = new ArrayList<String>();
    HashSet<Observer> observers = new HashSet();

    public static ChatHistory getInstance() {
        return ourInstance;
    }

    public void insert(String message) {
        history.add(message);
        notifyObservers(message);
    }

    @Override
    public String toString() {
        return Arrays.toString(history.toArray());
    }

    @Override
    public void notifyObservers(String message) {

    }

    @Override
    public void addObserver(Observer observer) {

    }
}
