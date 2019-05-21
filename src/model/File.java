package model;

import exceptions.GroupNotExistingException;

import java.util.ArrayList;
import java.util.List;

public abstract class File implements FileAction {
    String name;
    String type;
    List<Group> groups;

    public File() {
        name = new String("NoName");
        groups = new ArrayList<>();
    }

    public File(String name, String type) {
        this.name = name;
        this.type = type;
        this.groups = new ArrayList<>();
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

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public void changeGroup(Group oldGroup, Group newGroup) throws GroupNotExistingException {
        if (groups.contains(oldGroup)) {
            groups.set(groups.indexOf(oldGroup), newGroup);
        }
        else {
            throw new GroupNotExistingException("User not in old group");
        }
    }

    @Override
    public void deleteGroup(Group group) throws GroupNotExistingException{
        if (groups.contains(group)) {
            groups.remove(group);
        }
        else {
            throw new GroupNotExistingException("Group doesn't exist");
        }
    }  }
    }
}
