package repository;

import exceptions.GroupNotExistingException;
import model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    List<Group> groupList;

    public GroupRepository() {
        groupList = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void removeGroup(Group group) throws GroupNotExistingException{
        if (groupList.contains(group)) {
            groupList.remove(group);
        }
        else {
            throw new GroupNotExistingException("Group doesn't exist");
        }
    }
}
