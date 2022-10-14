package bo;

import ui.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Are accessible in controller
public class ProductHandler {
    public static Collection<ProductInfo> getItemsWithGroup(String s) {
        Collection c = Product.searchItems(s);
        ArrayList<ProductInfo> products = new ArrayList<>();
        for (Iterator it = c.iterator(); it.hasNext();) {
            Product product = (Product) it.next();
            products.add(new ProductInfo(product.getId(), product.getName(), product.getImgUrl(), product.getDescr(), product.getPrice()));
        }
        return products;
    }

}
