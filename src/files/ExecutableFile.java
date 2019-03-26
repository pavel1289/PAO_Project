package files;

public class ExecutableFile extends File{
    public ExecutableFile() {
        super("NoName", "Executable");
    }

    public ExecutableFile(String name) {
        super(name, "Executable");
    }

    public void execute() {
    }
}
