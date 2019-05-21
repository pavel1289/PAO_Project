package service;

import exceptions.UserNotExistingException;
import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void removerUser(User user) throws UserNotExistingException {
        userRepository.removerUser(user);
    }

    public List<User> getUserList() {
        userRepository.getUserList();
    }

    public void readUserList(String fileName) {
        List<User> userList = UserReaderService.readUsers(fileName);
        for (u : userList) {
            userRepository.addUser(u);
        }
    }
}
