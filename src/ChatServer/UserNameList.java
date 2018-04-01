package ChatServer;

import java.util.ArrayList;
import java.util.Arrays;

public class UserNameList {

    /*
     *UserNameList class insert usernames to list and could print them
     */

    ArrayList userList = new ArrayList<String>();

    public void setServerName(String name) {
        userList.add(name);
    }

    public void setClientName(String name) {
        userList.add(name);
    }

    @Override
    public String toString() {
        return Arrays.toString(userList.toArray());
    }
}
