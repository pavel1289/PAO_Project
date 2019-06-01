package model;

import model.File;

import java.util.ArrayList;
import java.util.List;

public class DirectoryFile extends File {
    List<File> files;

    public DirectoryFile(String name) {
        super(name);
        files = new ArrayList<>();
    }

    public List<File> getFiles() {
        return files;
    }

    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void printFile() {
        System.out.println(name + " DirectoryFile");
        files.forEach(p -> p.printFile());
    }
}
