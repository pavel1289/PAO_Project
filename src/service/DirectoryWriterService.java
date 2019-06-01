package service;

import model.DirectoryFile;
import model.File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DirectoryWriterService {
    public static void writeDirectoryFile(String path, DirectoryFile directoryFile) {
        Path pathFile = Paths.get(path + "\\" + directoryFile.getName() + "_files.csv.txt");
        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(pathFile)
                ) {
            List<File> fileList = directoryFile.getFiles();
            for (File file : fileList) {
                bufferedWriter.write(file.getName() + ", " + file.getClass().getName().replaceAll("model.", ""));
                bufferedWriter.newLine();
                if (file.getClass() == DirectoryFile.class) {
                    writeDirectoryFile(path, (DirectoryFile)file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
