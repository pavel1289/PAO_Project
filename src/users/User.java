package users;

import groups.Group;

import java.util.ConcurrentModificationException;

public interface User {
    void changePassword(CommonUser user,String newPassword);
    void changeName(CommonUser user, String newName);
    void changeFullName(CommonUser user, String newFullName);
    void addToGroup(CommonUser user, Group group);
    void removeFromGroup(CommonUser user, Group group);
}
