package users;

import groups.Group;

import java.util.ArrayList;

public class UserAction implements User, Administrator{
    @Override
    public void changePassword(CommonUser user, String newPassword) {
        user.setPassword(newPassword);
    }

    @Override
    public void changeName(CommonUser user, String newName) {
        user.setLoginName(newName);
    }

    @Override
    public void changeFullName(CommonUser user, String newFullName) {
        user.setFullName(newFullName);
    }

    @Override
    public void changeSomeoneElsePassword(AdministratorUser aUser, CommonUser user, String newPassword) {
        user.setPassword(newPassword);
    }

    @Override
    public void changeSomeoneElseName(AdministratorUser aUser, CommonUser user, String newName) {
        user.setLoginName(newName);
    }

    @Override
    public void changeSomeoneElseFullName(AdministratorUser aUser, CommonUser user, String newFullName) {
        user.setFullName(newFullName);
    }

    @Override
    public void addToGroup(CommonUser user, Group group) {
        user.groups.add(group);
        group.addUser(user);
    }

    @Override
    public void removeFromGroup(CommonUser user, Group group) {
        if (user.groups.contains(group)) {
            user.groups.remove(group);
        }
        group.deleteUser(user);
    }

    @Override
    public void deleteFile() {

    }
}
