package secretGarden;

import secretGarden.database.pseudoDatabase;
import secretGarden.enums.membership;
import secretGarden.enums.order;
import secretGarden.enums.sort;
import secretGarden.interfaces.webInterface;
import secretGarden.items.bread;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


public class secretGarden implements webInterface {

    public secretGarden() {
        this.generateFillData(50);
    }

    @Override
    public String placeOrders(customer customer, String collectionDate, ArrayList<Object> items) {
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

    public String placeOrders(customer customer, ArrayList<bread> items) {
        orders temporary = new orders(customer, order.STANDARD, items);
        pseudoDatabase.addOrder(temporary);
        // insert some database code to insert into database
        return temporary.getUUID();
    }

    public order getOrder(String uid) {
        return null;
    }

    @Override
    public ArrayList<bread> getAllStandardItems() {
        return pseudoDatabase.getAllBreads();
    }

    // ! FOR TEST DATA ONLY
    public void generateFillData(int amountOfItemsToGenerate) {
        ArrayList<bread> tempAllBread = new ArrayList<bread>();
        for (int i = 0; i < amountOfItemsToGenerate; i++) {
            Random random = new Random();
            bread temporary = new bread(UUID.randomUUID().toString(), random.nextDouble(), 100);
            tempAllBread.add(temporary);
        }
        pseudoDatabase.setAllBreads(tempAllBread);
    }

    /**
     * @param phoneNum
     * @return
     */
    public boolean checkIfCustomerExists(String phoneNum) {
        ArrayList<customer> allSignedUpCustomer = pseudoDatabase.getAllCustomer();
        boolean found = false;
        for (customer customer : allSignedUpCustomer) {
            if (customer.getCustomerID().equals(phoneNum)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public void createNewCustomer(String phoneNum, String name) {
        customer newCustomer = new customer(
                phoneNum,
                name,
                membership.STANDARD
        );
        pseudoDatabase.addCustomer(newCustomer);
    }

    public customer getCustomer(String phoneNum) {
        ArrayList<customer> allSignedUpCustomer = pseudoDatabase.getAllCustomer();
        customer found = null;
        for (customer customer : allSignedUpCustomer) {
            if (customer.getCustomerID().equals(phoneNum)) {
                found = customer;
                break;
            }
        }
        return found;
    }

    public ArrayList<orders> getThisCustomerOrder(String phoneNum, sort sortMethod) {
        ArrayList<orders> allOrders = this.getAllOrders();
        ArrayList<orders> filteredOrdersUnsort = new ArrayList<orders>();
        ArrayList<orders> filteredOrderSort = new ArrayList<orders>();

        for (orders currentOrder : allOrders) {
            customer orderOwner = currentOrder.getOwner();
            customer inputOwner = this.getCustomer(phoneNum);
            if (orderOwner.hashCode() == inputOwner.hashCode()) {
                filteredOrdersUnsort.add(currentOrder);
            }
        }

        // we have all the customers orders.
        // https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
        switch (sortMethod) {
            //TODO sort the thing
            case DATE -> {
            }
            case TYPE -> {
            }
            case AMOUNT_OF_ITEMS -> {
            }
            case ORDER_PRICE -> {
            }
            default -> filteredOrderSort = filteredOrdersUnsort;
        }
        return filteredOrderSort;
    }

    private ArrayList<orders> getAllOrders() {
        return pseudoDatabase.getAllOrders();
    }
}