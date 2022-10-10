package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasetest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hplus", "root", "rootroot");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver in not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
    }
}
