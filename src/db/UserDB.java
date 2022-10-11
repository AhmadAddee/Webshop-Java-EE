package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {

    public boolean validateUser(String username, String password) {
        boolean isValidUser = false;
        try {
            Connection connection = DBManager.getConnection();

            String sql = "select * from furniture_db.users where username=? and password=?";

            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                isValidUser = true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return isValidUser;
    }
}
