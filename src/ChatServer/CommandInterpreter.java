package ChatServer;

import java.util.Observable;
import java.util.Observer;

/*
 *CommandInterpreter check if message from console was a command
 */

public class CommandInterpreter implements Observer {

    public int commandCase(String input) {
        switch (input) {
            case ":users":      //Show you the list of users in dialog
                return 1;
            case ":help":       //Show this instructions again
                return 2;
            case ":quit":       //Leave the dialogue
                return 3;
            case ":history":    //Show your conversation again
                return 4;
        }
        return 0;
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
