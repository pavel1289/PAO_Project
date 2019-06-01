package model;

import model.File;

public class ExecutableFile extends File {

    public ExecutableFile(String name) {
        super(name);
    }

    public void execute() {
        System.out.println("Executing file " + name);
    }

    @Override
    public void printFile() {
        System.out.println(name + " ExecutableFile");
    }
}
