package files;

import groups.Group;

import java.util.ArrayList;

public abstract class File {
    String name;
    String type;
    ArrayList<Group> groups;

    public File() {
        name = new String("NoName");
    }

    public File(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }
}
