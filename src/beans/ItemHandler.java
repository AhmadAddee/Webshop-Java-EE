package beans;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> getItemsWithGroup(String s) {
        Collection c = Product.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<>();
        for (Iterator it = c.iterator(); it.hasNext();) {
            Product item = (Product) it.next();
            items.add(new ItemInfo(item.getName(), item.getDescr()));
        }
        return items;
    }
}
