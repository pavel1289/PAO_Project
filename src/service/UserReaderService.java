package service;

import model.DirectoryFile;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserReaderService {
    public static List<User> readUsers(String path, String fileName) {
        List<User> userList = new ArrayList<>();
        Path pathToFile = Paths.get(path + "\\" + fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] attributes = line.split(", ");
                DirectoryFile root = DirectoryReaderService.readDirectoryFile(path, attributes[3] + "_files.csv.txt");
                root.setName(attributes[3]);
                User user = new User(attributes[0], attributes[1], attributes[2], root);
                userList.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
