package db;

import beans.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    public List<Product> searchProducts(String searchString, Connection connection) {
        Product product = null;
        List<Product> products = new ArrayList<>();
        // Connection connection = DBConnection.getConnectionToDatabase();
        try {

            String sql = "select * from furniture_db.products where product_name like '%" + searchString + "%'";

            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                product = new Product();
                product.setId(set.getInt("product_id"));
                product.setName(set.getString("product_name"));
                product.setImgUrl(set.getString("image_url"));
                product.setDescr(set.getString("product_description"));
                product.setPrice(set.getFloat("product_price"));
                products.add(product);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
