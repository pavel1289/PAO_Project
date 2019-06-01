package service;

import model.DirectoryFile;
import model.ExecutableFile;
import model.File;
import model.TextFile;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryReaderService {
    public static DirectoryFile readDirectoryFile(String path, String fileName) {
        DirectoryFile directoryFile = new DirectoryFile("DirectoryFileX");
        Path pathToFile = Paths.get(path + "\\" + fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String [] attributes = line.split(", ");
                File file;
                if (attributes[1].equals("ExecutableFile")) {
                    file = new ExecutableFile(attributes[0]);
                } else if (attributes[1].equals("TextFile")) {
                    file = new TextFile(attributes[0]);
                } else {
                    file = DirectoryReaderService.readDirectoryFile(path, attributes[0] + "_files.csv.txt");
                    file.setName(attributes[0]);
                }
                directoryFile.addFile(file);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directoryFile;
    }
}
