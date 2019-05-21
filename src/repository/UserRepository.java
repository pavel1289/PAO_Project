package repository;

import exceptions.UserNotExistingException;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> userList;

    public UserRepository() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void removerUser(User user) throws UserNotExistingException {
        if (userList.contains(user)) {
            userList.remove(user);
        }
        else {
            throw new UserNotExistingException("User doesn't exist");
        }
    }
}
