package users;

import groups.Group;

import java.util.ArrayList;

public class CommonUser {
    String loginName;
    String fullName;
    String password;
    ArrayList<Group> groups;

    public CommonUser(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
        this.groups = new ArrayList<Group>(0);
    }

    public CommonUser(String loginName, String fullName, String password) {
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
}
