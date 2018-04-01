package ChatServer;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * ChatMessage class assign timestamp to message and save it to history in formatted shape
 */

public class ChatMessage {

    private UserNameList unl = new UserNameList();
    private Timestamp time = new Timestamp(System.currentTimeMillis());
    private DateFormat format = new SimpleDateFormat("h:mm a");
    private String timestamp = format.format(time);

    public String printMessage(String user, String message) {

        String tmpMsg = user + ": " + message + "~" + timestamp + "\n";
        unl.setClientName(user);
        ChatHistory.getInstance().insert(tmpMsg);
        return tmpMsg;
    }
}