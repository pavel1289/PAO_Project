package users;

public interface Administrator extends User {
    void changeSomeoneElsePassword(AdministratorUser aUser, CommonUser user, String newPassword);
    void changeSomeoneElseName(AdministratorUser aUser, CommonUser user, String newName);
    void changeSomeoneElseFullName(AdministratorUser aUser, CommonUser user, String newFullName);
    void deleteFile();
}
