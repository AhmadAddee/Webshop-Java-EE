package beans;

import db.UserValidator;

public class UserHandler {

    public static boolean validateUser(String username, String password) {
        boolean isValidUser = UserValidator.validateUser(username, password);
        return isValidUser;
    }
}
