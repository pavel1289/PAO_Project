package model;

import model.File;

public class RegularFile extends File {
    public RegularFile() {
        super("NoName", "Regular File");
    }

    public RegularFile(String name) {
        super(name, "Regular File");
    }
}
