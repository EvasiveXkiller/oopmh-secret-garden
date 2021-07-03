import java.util.ArrayList;

public interface webInterface {
    ArrayList<bread> getAllItems();
    String placeOrders(order type, String collectionDate, ArrayList<Object> items);
}
