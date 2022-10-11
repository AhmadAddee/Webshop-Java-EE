package beans;

import java.util.List;

public class ShoppingCart {
    private User user;
    private List<Product> productsInCart;

    public ShoppingCart(User user, List<Product> productsInCart) {
        this.user = user;
        this.productsInCart = productsInCart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }
}
