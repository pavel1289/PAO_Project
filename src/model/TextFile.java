package model;

public class TextFile extends File{
    public TextFile(String name) {
        super(name);
    }

    @Override
    public void printFile() {
        System.out.println(name + " TextFile");
    }
}
