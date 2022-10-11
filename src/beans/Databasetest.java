package beans;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Databasetest {
    public static void main(String[] args) {
        User user = new User();
        Product product = new Product(0, "name", "url", "description", 56);
        List<Product> products = new ArrayList<>();
        products.add(product);
        Connection connection = null;
        try {
            connection = DBManager.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from furniture_db.users where username='Ahmad'");
            while (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAddress(resultSet.getString("address"));
                System.out.println(user.getUsername() +" " + user.getPassword() +" " + user.getFirstName() +" " +  user.getLastName()+" " + user.getAddress());
            }
            resultSet = statement.executeQuery("select * from furniture_db.products where product_description='sofa'");
            while (resultSet.next()) {
                product.setId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("product_name"));
                product.setImgUrl(resultSet.getString("image_url"));
                product.setDescr(resultSet.getString("product_description"));
                product.setPrice(resultSet.getFloat("product_price"));
                System.out.println(product.getId()+" " + product.getName()+" " + product.getImgUrl()+" " + product.getDescr()+" " + product.getPrice());
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        products.add(product);
        ShoppingCart cart = new ShoppingCart(user, products);
        for (int i = 0; i < cart.getProductsInCart().size(); i++){
            System.out.println(cart.getUser().getUsername() + " " + cart.getProductsInCart().get(i).getDescr());
        }
        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
    }
}
