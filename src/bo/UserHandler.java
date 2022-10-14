package bo;

public class UserHandler {

    public static boolean validateUser(String username, String password) {
        boolean isValidUser = User.searchUser(username, password);
        return isValidUser;
    }
}
