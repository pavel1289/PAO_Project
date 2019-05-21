package service;

import model.Group;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GroupReaderService {
    public static List<Group> readGroups(String fileName) {
        List<Group> groupList = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Group group = new Group(attributes[0]);
                groupList.add(group);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupList;
    }
}
