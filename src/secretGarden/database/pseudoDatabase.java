package secretGarden.database;

import secretGarden.customer;
import secretGarden.enums.order;
import secretGarden.interfaces.databaseInterface;
import secretGarden.items.bread;
import secretGarden.orders;

import java.util.ArrayList;

/**
 * Class that acts as a pseudoDatabase;
 * Since this project should be done in an environment this is a pseudoInterface to make this project more manageable
 */
public class pseudoDatabase implements databaseInterface {
    // pseudo database
    private static ArrayList<bread> allBreads = new ArrayList<bread>();
    private static ArrayList<orders> allOrders = new ArrayList<orders>();
    private static ArrayList<customer> allCustomers = new ArrayList<customer>();
    // end of pseudo database


    /**
     * Adds a new order to the end of the list
     *
     * @param orders The order to add to the list
     */
    public static void addOrder(orders orders) {
    }

    /**
     * Finds from the database for the given order;
     *
     * @param uid The id of the order
     * @return The order if its found, else null
     */
    static orders getOrder(String uid) {
        return null;
    }

    /**
     * Adds a new customer to the end of the list
     *
     * @param customer The customer object
     */
    static void addCustomer(customer customer) {

    }

    /**
     * Gets the specified customer object from the database
     *
     * @param uid The id of the customer [in this case phone number]
     * @return the customer details;
     */
    static customer getCustomer(String uid) {
        return null;
    }


    // Getters and Setters
    public static ArrayList<bread> getAllBreads() {
        return allBreads;
    }

    public static void setAllBreads(ArrayList<bread> allBreads) {
        pseudoDatabase.allBreads = allBreads;
    }

}
