package model;

public class User {
    String loginName;
    String fullName;
    String password;
    DirectoryFile rootDirectoryFile;

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
        this.rootDirectoryFile = new DirectoryFile(loginName + "_files.csv.txt");
    }

    public User(String loginName, String fullName, String password, DirectoryFile rootDirectoryFile) {
        this.loginName = loginName;
        this.fullName = fullName;
        this.password = password;
        this.rootDirectoryFile = rootDirectoryFile;
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

    public DirectoryFile getRootDirectoryFile() {
        return rootDirectoryFile;
    }

    public void changePassword(String newPassword) {
        this.setPassword(newPassword);
    }

    public void changeName(String newName) {
        this.setLoginName(newName);
    }

    public void changeFullName(String newFullName) {
        this.setFullName(newFullName);
    }

    public void printFiles() {
        System.out.println("Files of " + loginName);
        rootDirectoryFile.printFile();
    }
}
