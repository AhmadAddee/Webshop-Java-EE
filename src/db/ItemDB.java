package db;

import beans.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Product {

    public static Collection searchItems(String item_group) {
        Vector v = new Vector();
        try {

            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("selectid, name, description from furniture_db");

            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                String desc = resultSet.getNString("description");
                v.addElement(new ItemDB(i, name, desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    private ItemDB(int id, String name, String desc) {
        super(id, name, desc, null, 0);
    }
}
