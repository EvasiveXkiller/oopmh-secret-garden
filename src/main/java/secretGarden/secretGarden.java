package secretGarden;

import secretGarden.database.pseudoDatabase;
import secretGarden.enums.membership;
import secretGarden.enums.order;
import secretGarden.enums.sort;
import secretGarden.interfaces.webInterface;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.utils.utils;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class secretGarden implements webInterface {

    /**
     * Constructor, calls the dummy data generator immediately
     */
    public secretGarden() {
        this.generateFillData();
    }

    /**
     * Places a new order, Pre Order type
     *
     * @param customer       the customer that owns this order
     * @param collectionDate the collection date
     * @param itemBread      any bread items
     * @param itemCake       any cake items
     * @return the order ID
     */
    public String placeOrders(customer customer, LocalDateTime collectionDate, ArrayList<bread> itemBread, ArrayList<cake> itemCake) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
        orders temporary = new orders(
                customer,
                order.PRE_ORDER,
                dtf.format(collectionDate),
                itemBread,
                itemCake);
        pseudoDatabase.addOrder(temporary);
        return temporary.getUid();
    }

    /**
     * Places a new order, Standard type
     *
     * @param customer the customer that owns this order
     * @param items    the bread items in the order
     * @return the order iD
     */
    public String placeOrders(customer customer, ArrayList<bread> items) {
        orders temporary = new orders(customer, order.STANDARD, items);
        pseudoDatabase.addOrder(temporary);
        // insert some database code to insert into database
        return temporary.getUid();
    }


    /**
     * Checks if the customer is in the database
     *
     * @param phoneNum Phone number as ID
     * @return If the customer exists
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
     * Creates a new customer,
     *
     * @param phoneNum Using phone number as an ID
     * @param name     Name of the customer
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
     * Gets the customer object from the database
     *
     * @param phoneNum the ID of the customer to get
     * @return the customer object
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
     * Gets all the orders of a specific customer
     *
     * @param phoneNum   the id of the customer
     * @param sortMethod the sort method
     * @return an arraylist of orders
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


    /**
     * Gets a single order based on the order ID
     *
     * @param ID the order ID
     * @return the order
     */
    @Override
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

    // getters and setter
    private ArrayList<orders> getAllOrders() {
        return pseudoDatabase.getAllOrders();
    }

    public ArrayList<bread> getAllStandardItems() {
        return pseudoDatabase.getAllBreads();
    }

    public ArrayList<cake> getAllCakesItems() {
        return pseudoDatabase.getAllCakes();
    }

    /**
     * TEST DATA ONLY
     *
     * @param amountOfItemsToGenerate The amount of test data to insert into the database
     */
    public void generateFillData() {
        ArrayList<cake> tempAllCake = new ArrayList<>();
        ArrayList<bread> tempAllBread = new ArrayList<>();
        
        tempAllBread.add(new bread("Ciabatta Bread", 15));
        tempAllBread.add(new bread("Banana Bread", 7.5));
        tempAllBread.add(new bread("Baguette Bread", 18));
        tempAllBread.add(new bread("Wheat Bread", 12));
        tempAllBread.add(new bread("Hot-Dog Bread", 8.5));
            
        tempAllCake.add(new cake("VANILLA", 77));
        tempAllCake.add(new cake("TIRAMISU", 770));
        tempAllCake.add(new cake("CHOCOLATE", 7700));
        pseudoDatabase.setAllCakes(tempAllCake);
        pseudoDatabase.setAllBreads(tempAllBread);
    }
}