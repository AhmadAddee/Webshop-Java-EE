package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {

    public boolean validateUser(String username, String password) {
        boolean isValidUser = false;
        try {

            // get the connection for the database
            Connection connection = DBManager.getConnection();

            // write the select query
            String sql = "select * from furniture_db.users where username=? and password=?";
            // set parameters with PreparedStatement
            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // execute the statement and check whether user exists

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
