package model;

public interface FileAction {
    public void changeGroup(Group oldGroup, Group newGroup);
    public void deleteGroup(Group group);
}
