package files;

import java.util.ArrayList;

public class DirectoryFile extends File{
    ArrayList<File> files;

    public DirectoryFile(String name) {
        super(name, "Directory");
        files = null;
    }
    public DirectoryFile() {
        super("NoName", "Directory");
        files = null;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void addFile(File file) {
        files.add(file);
    }
}
