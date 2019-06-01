package repository;

import exceptions.UserNotExistingException;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private String url = "jdbc:mysql://localhost/proiect";
    private String username = "";
    private String password = "";
    List<User> userList;

    public UserRepository() {
        userList = new ArrayList<>();
    }

    public UserRepository(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void removerUser(User user) throws UserNotExistingException {
        if (userList.contains(user)) {
            userList.remove(user);
        }
        else {
            throw new UserNotExistingException("User doesn't exist");
        }
    }

    public User getUserByLoginName(String loginName) {
        for(User user : userList) {
            if (user.getLoginName().equals(loginName))
                return user;
        }
        return null;
    }

    public void addUserDB(User user) {
        String q1 = "INSERT INTO users VALUES (?, ?)";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(q1);
        ) {
            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserDB(String userName) {
        User user = new User("", "");
        user.setLoginName(userName);
        String q1 = "SELECT * from users where login_name == " + userName;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(q1);
                ResultSet resultSet = preparedStatement.executeQuery(q1);
        ) {
            user.setFullName(resultSet.getString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUserDB(String userName) {
        String q1 = "DELETE from groups where group_name == " + userName;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(q1);
        ) {
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
