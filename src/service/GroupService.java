package service;

import exceptions.GroupNotExistingException;
import model.Group;
import repository.GroupRepository;

import java.util.List;

public class GroupService {
    private GroupRepository groupRepository;

    public GroupService() {
        groupRepository = new GroupRepository();
    }

    public List<Group> getGroupList() {
        groupRepository.getGroupList();
    }

    public void addGroup(Group group) {
        groupRepository.addGroup(group);
    }

    public void removeGroup(Group group) throws GroupNotExistingException {
        groupRepository.removeGroup(group);
    }

    public void readGroupList(String fileName) {
        List<Group> groupList = GroupReaderService.readGroups(fileName);
        for (g : groupList) {
            groupRepository.addGroup(g);
        }
    }
}
