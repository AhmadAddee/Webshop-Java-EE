package beans;

import db.ProductDB;
import db.UserDB;

import java.util.List;

public class ShoppingCart {
    private List<ProductDB> productsInCart;

    public ShoppingCart(UserDB user, List<ProductDB> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public List<ProductDB> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<ProductDB> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
