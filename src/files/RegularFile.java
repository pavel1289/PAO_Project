package files;

public class RegularFile extends File{
    public RegularFile() {
        super("NoName", "Regular File");
    }

    public RegularFile(String name) {
        super(name, "Regular File");
    }

    public void openFile() {}
    public void closeFile() {}
}
