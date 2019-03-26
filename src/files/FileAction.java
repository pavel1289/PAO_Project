package files;

import groups.Group;
import users.CommonUser;

public interface FileAction {
    public void changeGroup(Group oldGroup, Group newGroup) {
        if (groups.contains(oldGroup)) {
            groups.set(groups.indexOf(oldGroup), newGroup);
        }
        else {
            System.out.println("Grup inexistent");
        }
    }

    public void deleteGroup(Group group) {
        if (groups.contains(group)) {
            groups.remove(group);
        }
        else {
            System.out.println("Grup inexistent");
        }
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void createNewFile(CommonUser user, String type)
}
