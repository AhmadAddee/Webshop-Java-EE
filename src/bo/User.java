package bo;

import db.UserDB;

public class User {

    private String username;
    private String password;

    static public boolean searchUser(String username, String password) {
        return UserDB.validateUser(username, password);
    }

    protected User(String username, String password) {

        this.username = username;
        this.password = password;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}