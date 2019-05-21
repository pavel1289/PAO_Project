package model;

import exceptions.GroupNotExistingException;

import java.util.ArrayList;
import java.util.List;

public class User implements RegularUser, Administrator{
    String loginName;
    String fullName;
    String password;
    List<Group> groups;

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
        this.groups = new ArrayList<>(0);
    }

    public User(String loginName, String fullName, String password) {
        this.loginName = loginName;
        this.fullName = fullName;
        this.password = password;
        this.groups = new ArrayList<Group>(0);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public void changePassword(String newPassword) {
        this.setPassword(newPassword);
    }

    @Override
    public void changeName(String newName) {
        this.setLoginName(newName);
    }

    @Override
    public void changeFullName(String newFullName) {
        this.setFullName(newFullName);
    }

    @Override
    public void changeSomeoneElsePassword(RegularUser regularUser, String newPassword) {
        regularUser.changePassword(newPassword);
    }

    @Override
    public void changeSomeoneElseName(RegularUser regularUser, String newName) {
        regularUser.changeName(newName);
    }

    @Override
    public void changeSomeoneElseFullName(RegularUser regularUser, String newFullName) {
        regularUser.changeFullName(newFullName);
    }

    @Override
    public void addToGroup(User user, Group group) {
        user.groups.add(group);
        group.addUser(user);
    }

    @Override
    public void removeFromGroup(User user, Group group) throws GroupNotExistingException{
        if (user.groups.contains(group)) {
            user.groups.remove(group);
        }
        else {
            throw new GroupNotExistingException("User is not in this group");
        }
        group.deleteUser(user);
    }
}
