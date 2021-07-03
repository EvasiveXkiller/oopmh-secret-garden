import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


public class secretGarden implements webInterface {
    // pseudo database
    static ArrayList<bread> allBreads = new ArrayList<bread>();
    static ArrayList<orders> allOrders = new ArrayList<orders>();
    static ArrayList<customer> allCustomers = new ArrayList<customer>();
    // end of pseudo database

    secretGarden() {
        this.generateFillData();
    }

    @Override
    public String placeOrders(order type, String collectionDate, ArrayList<Object> items) {
        orders temporary = new orders(type, collectionDate, items);
        allOrders.add(temporary);
        // insert some database code to insert into database
        return temporary.getUUID();
    }

    public String placeOrders(order type, ArrayList<Object> items) {
        orders temporary = new orders(type, items);
        allOrders.add(temporary);
        // insert some database code to insert into database
        return temporary.getUUID();
    }

    public order getOrder(String uid) {
        
    }

    @Override
    public ArrayList<bread> getAllItems() {
        return allBreads;
    }

    // ! FOR TEST DATA ONLY
    public void generateFillData() {
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            bread temporary = new bread(UUID.randomUUID().toString(), random.nextDouble(), 100);
            allBreads.add(temporary);
        }
    }
}