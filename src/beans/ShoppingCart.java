package beans;

import db.ProductDB;
import db.UserDB;

import java.util.List;

public class ShoppingCart {
    private UserDB user;
    private List<ProductDB> productsInCart;

    public ShoppingCart(UserDB user, List<ProductDB> productsInCart) {
        this.user = user;
        this.productsInCart = productsInCart;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public List<ProductDB> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<ProductDB> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
