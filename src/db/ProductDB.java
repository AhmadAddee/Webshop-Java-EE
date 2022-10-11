package db;

import beans.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDB extends Product{


    public static Collection searchProducts(String name) {
        List list = new ArrayList();

        try {
            String sql = "select * from furniture_db.products where product_name like '%" + name + "%'";

            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                int id = set.getInt("product_id");
                String product_name = (set.getString("product_name"));
                String imgUrl = (set.getString("image_url"));
                String desc = (set.getString("product_description"));
                float price = (set.getFloat("product_price"));
                list.add(new ProductDB(id, product_name, imgUrl, desc, price));

            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    private ProductDB(int id, String name, String imgUrl, String desc, float price) {
        super(id, name, imgUrl, desc, price);
    }
}
