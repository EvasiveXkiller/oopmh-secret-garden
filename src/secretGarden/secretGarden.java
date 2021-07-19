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

    public String placeOrders(customer customer, LocalDateTime collectionDate, ArrayList<bread> itemBread, ArrayList<cake> itemCake) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        orders temporary = new orders(
                customer,
                order.PRE_ORDER,
                dtf.format(collectionDate),
                itemBread,
                itemCake);
        pseudoDatabase.addOrder(temporary);
        // insert some database code to insert into database
        return temporary.getUid();
    }

    public String placeOrders(customer customer, ArrayList<bread> items) {
        orders temporary = new orders(customer, order.STANDARD, items);
        pseudoDatabase.addOrder(temporary);
        // insert some database code to insert into database
        return temporary.getUid();
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
        ArrayList<cake> tempAllCake = new ArrayList<>();
        ArrayList<bread> tempAllBread = new ArrayList<>();
        for (int i = 0; i < amountOfItemsToGenerate; i++) {
            Random random = new Random();
            bread temporary = new bread(UUID.randomUUID().toString(), random.nextDouble());
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
        ArrayList<orders> filteredOrdersUnsort = new ArrayList<>();
        ArrayList<orders> filteredOrderSort;

        for (orders currentOrder : allOrders) {
            customer orderOwner = currentOrder.getOwner();
            customer inputOwner = this.getCustomer(phoneNum);
            if (orderOwner.hashCode() == inputOwner.hashCode()) {
                filteredOrdersUnsort.add(currentOrder);
            }
        }
        // we have all the customers orders.
        switch (sortMethod) {
            //TODO sort the thing
            case DATE:
                filteredOrderSort = utils.sortOrderByDate(filteredOrdersUnsort);
                break;
            case TYPE:
                filteredOrderSort = utils.sortOrderByType(filteredOrdersUnsort);
                break;
            case AMOUNT_OF_ITEMS:
                filteredOrderSort = utils.sortOrderByItems(filteredOrdersUnsort);
                break;
            case ORDER_PRICE:
                filteredOrderSort = utils.sortOrderByPrice(filteredOrdersUnsort);
                break;
            default:
                filteredOrderSort = filteredOrdersUnsort;
        }
        return filteredOrderSort;
    }

    public orders getThisCustomerOrderSingle(String ID) {
        ArrayList<orders> allOrders = this.getAllOrders();
        orders order = null;
        for (orders orderlocal : allOrders) {
            if (orderlocal.getUid().equals(ID)) {
                order = orderlocal;
                break;
            }
        }
        return order;
    }

    private ArrayList<orders> getAllOrders() {
        return pseudoDatabase.getAllOrders();
    }
}