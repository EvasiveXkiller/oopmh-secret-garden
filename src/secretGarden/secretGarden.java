package secretGarden;

import secretGarden.database.pseudoDatabase;
import secretGarden.enums.membership;
import secretGarden.enums.order;
import secretGarden.enums.sort;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.utils.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


public class secretGarden {

    public secretGarden() {
        this.generateFillData(50);
    }

    public String placeOrders(customer customer, LocalDateTime collectionDate, ArrayList items) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        orders temporary = new orders(
                customer,
                order.PRE_ORDER,
                dtf.format(collectionDate),
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

    public ArrayList<bread> getAllStandardItems() {
        return pseudoDatabase.getAllBreads();
    }

    public ArrayList<cake> getAllCakesItems() {
        return pseudoDatabase.getAllCakes();
    }

    /**
     * TEST DATA [CARLSON]
     *
     * @param amountOfItemsToGenerate
     */
    public void generateFillData(int amountOfItemsToGenerate) {
        ArrayList<cake> tempAllCake = new ArrayList<cake>();
        ArrayList<bread> tempAllBread = new ArrayList<bread>();
        for (int i = 0; i < amountOfItemsToGenerate; i++) {
            Random random = new Random();
            bread temporary = new bread(UUID.randomUUID().toString(), random.nextDouble(), 100);
            tempAllBread.add(temporary);
        }
        tempAllCake.add(new cake("VANILLA", 77));
        tempAllCake.add(new cake("TIRAMISU", 770));
        tempAllCake.add(new cake("CHOCOLATE", 7700));
        pseudoDatabase.setAllCakes(tempAllCake);
        pseudoDatabase.setAllBreads(tempAllBread);
    }

    /**
     * Method to check if customer exists from the database [CARLSON]
     *
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

    /**
     * Creates a new customer [CARLSON]
     *
     * @param phoneNum
     * @param name
     */
    public void createNewCustomer(String phoneNum, String name) {
        customer newCustomer = new customer(
                phoneNum,
                name,
                membership.STANDARD
        );
        pseudoDatabase.addCustomer(newCustomer);
    }

    /**
     * Gets the customer information [CARLSON]
     *
     * @param phoneNum
     * @return
     */
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

    /**
     * Get all the orders from the specified customer [PAVAN]
     *
     * @param phoneNum
     * @param sortMethod
     * @return
     */
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
            case DATE:
                filteredOrderSort = utils.sortOrderByDate(filteredOrdersUnsort);
                break;
            case TYPE:

                break;
            case AMOUNT_OF_ITEMS:

                break;
            case ORDER_PRICE:

                break;

            default:
                filteredOrderSort = filteredOrdersUnsort;
        }
        return filteredOrderSort;
    }

    private ArrayList<orders> getAllOrders() {
        return pseudoDatabase.getAllOrders();
    }
}