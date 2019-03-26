package groups;

import users.CommonUser;

import java.util.ArrayList;

public class Group {
    String name;
    ArrayList<CommonUser> users;

    public Group(String name) {
        this.name = name;
        this.users = new ArrayList<CommonUser>(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CommonUser> getUsers() {
        return users;
    }

    public void addUser(CommonUser user) {
        users.add(user);
    }

    public void deleteUser(CommonUser user) {
        if (users.contains(user)) {
            users.remove(user);
        }
    }
}
