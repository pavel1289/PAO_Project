package service;

import model.DirectoryFile;
import model.File;
import model.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserWriterService {
    public static void writeUsers(String path, List<User> userList) {
        Path pathFile = Paths.get(path + "\\" + "users.csv.txt");
        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(pathFile)
        ) {
            for (User user : userList) {
                bufferedWriter.write(user.getLoginName() + ", " + user.getFullName() + ", "
                        + user.getPassword() + ", " + user.getRootDirectoryFile().getName());
                bufferedWriter.newLine();
                DirectoryWriterService.writeDirectoryFile(path, user.getRootDirectoryFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
