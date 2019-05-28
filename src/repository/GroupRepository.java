package repository;

import exceptions.GroupNotExistingException;
import model.Group;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupRepository {
    private String url = "jdbc:mysql://localhost/lab12";
    private String username = "";
    private String password = "";
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

    public void addGroupDB(Group group) {
        String q1 = "INSERT INTO groups VALUES (?, ?)";
        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(q1);
            ) {
            Iterator<User> it = group.getUsers().iterator();
            while (it.hasNext()) {
                User u = it.next();
                preparedStatement.setString(1, group.getName());
                preparedStatement.setString(2, u.getLoginName());
                preparedStatement.addBatch();
            }
            int [] numUpdates = preparedStatement.executeBatch();
            for (int i = 0; i < numUpdates.length; i++) {
                if (numUpdates[i] == -2)
                    System.out.println("Execution " + i + " failed");
                else
                    System.out.println("Execution " + i + " succes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Group getGroupDB(String groupName) {
        Group group = new Group();
        group.setName(groupName);
        String q1 = "SELECT group_name group from groups";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(q1);
                ResultSet resultSet = preparedStatement.executeQuery(q1);
                ) {
            while (resultSet.next()) {
                String gN = resultSet.getString(1);
                String userName = resultSet.getString(2);
                if (groupName.compareTo(gN)) {
                    ///add user to group's user list
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return group;
    }

    public void deleteGroupDB(String groupName) {
        String q1 = "DELETE from groups where group_name == ?";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(q1);
                ) {
            preparedStatement.setString(1, groupName);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
