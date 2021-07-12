package secretGarden;

import secretGarden.database.pseudoDatabase;
import secretGarden.enums.membership;
import secretGarden.enums.order;
import secretGarden.interfaces.webInterface;
import secretGarden.items.bread;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


public class secretGarden implements webInterface {

    public secretGarden() {
        this.generateFillData();
    }

    @Override
    public String placeOrders(order type, String collectionDate, ArrayList<Object> items) {
        // placeholder entry, need subroutine to figure out if customer exists
        orders temporary = new orders(
                new customer(
                        "asdasd",
                        membership.STANDARD,
                        0),
                type,
                collectionDate,
                items);
        pseudoDatabase.addOrder(temporary);
        // insert some database code to insert into database
        return temporary.getUUID();
    }

    public String placeOrders(order type, ArrayList<Object> items) {
        orders temporary = new orders(type, items);
        pseudoDatabase.addOrder(temporary);
        // insert some database code to insert into database
        return temporary.getUUID();
    }

    public order getOrder(String uid) {
        return null;
    }

    @Override
    public ArrayList<bread> getAllItems() {
        return pseudoDatabase.getAllBreads();
    }

    // ! FOR TEST DATA ONLY
    public void generateFillData() {
        ArrayList<bread> tempAllBread = new ArrayList<bread>();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            bread temporary = new bread(UUID.randomUUID().toString(), random.nextDouble(), 100);
            tempAllBread.add(temporary);
        }
        pseudoDatabase.setAllBreads(tempAllBread);
    }
}