package model;

public interface Administrator extends RegularUser {
    void changeSomeoneElsePassword(RegularUser regularUser, String newPassword);
    void changeSomeoneElseName(RegularUser regularUser, String newName);
    void changeSomeoneElseFullName(RegularUser regularUser, String newFullName);
    void addToGroup(User user, Group group);
    void removeFromGroup(User user, Group group);
}
