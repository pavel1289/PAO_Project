package model;

import exceptions.UserNotExistingException;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    List<User> users;

    public Group(String name) {
        this.name = name;
        this.users = new ArrayList<>(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) throws UserNotExistingException{
        if (users.contains(user)) {
            users.remove(user);
        }
        else {
            throw new UserNotExistingException("User isn't in this group");
        }
    }
}
