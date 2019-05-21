package model;

import model.File;

import java.util.ArrayList;
import java.util.List;

public class DirectoryFile extends File {
    List<File> files;

    public DirectoryFile(String name) {
        super(name, "Directory");
        files = new ArrayList<>();
    }
    public DirectoryFile() {
        super("NoName", "Directory");
        files = new ArrayList<>();
    }

    public List<File> getFiles() {
        return files;
    }

    public void addFile(File file) {
        files.add(file);
    }
}
