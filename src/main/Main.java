package main;

import gui.basePage;
import model.DirectoryFile;
import model.ExecutableFile;
import model.TextFile;
import model.User;
import service.DirectoryWriterService;
import service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\FMI\\Anul II\\Semestrul 2\\Programare avansata pe obiecte\\PAO_Project\\infos";
        String fileName = "users.csv.txt";
        UserService userService = UserService.getInstance(path, fileName);
        List<User> usersList = userService.getUserList();
        User user = usersList.get(0);
        user.printFiles();
        userService.writeUsers(path);
        basePage b = basePage.getInstance();
    }
}
