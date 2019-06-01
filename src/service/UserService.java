package service;

import exceptions.UserNotExistingException;
import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;
    private static UserService userService;

    public static UserService getInstance(String path, String fileName) {
        if (userService == null) {
            synchronized (UserService.class) {
                if (userService == null) {
                    userService = new UserService(path, fileName);
                }
            }
        }
        return userService;
    }

    private UserService(String path, String fileName) {
        userRepository = new UserRepository(UserReaderService.readUsers(path, fileName));
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void removerUser(User user) throws UserNotExistingException {
        userRepository.removerUser(user);
    }

    public List<User> getUserList() {
        return userRepository.getUserList();
    }

    public User getUserByLoginName(String loginName) {
        return userRepository.getUserByLoginName(loginName);
    }

    public void writeUsers(String path) {
        UserWriterService.writeUsers(path, userRepository.getUserList());
    }
}
