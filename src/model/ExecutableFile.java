package model;

import model.File;

public class ExecutableFile extends File {
    public ExecutableFile() {
        super("NoName", "Executable");
    }

    public ExecutableFile(String name) {
        super(name, "Executable");
    }

    public void execute() {
        System.out.println("Executing file " + name);
    }
}
