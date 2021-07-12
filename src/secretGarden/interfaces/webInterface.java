package secretGarden.interfaces;

import secretGarden.items.bread;
import secretGarden.enums.order;

import java.util.ArrayList;

public interface webInterface {
    ArrayList<bread> getAllStandardItems();
    String placeOrders(order type, String collectionDate, ArrayList<Object> items);
}
