package secretGarden.database;

import secretGarden.customer;
import secretGarden.interfaces.databaseInterface;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.orders;

import java.util.ArrayList;

/**
 * Class that acts as a pseudoDatabase;
 * Since this project should be done in an environment this is a pseudoInterface to make this project more manageable
 */
public class pseudoDatabase implements databaseInterface {
    // pseudo database
    private static ArrayList<bread> allBreads = new ArrayList<bread>();
    private static ArrayList<cake> allCakes = new ArrayList<cake>();
    private static final ArrayList<orders> allOrders = new ArrayList<orders>();
    private static final ArrayList<customer> allCustomers = new ArrayList<customer>();
    // end of pseudo database

    /**
     * Adds a new order to the end of the list
     *
     * @param orders The order to add to the list
     */
    public static void addOrder(orders orders) {
        allOrders.add(orders);
    }

    /**
     * Finds from the database for the given order;
     *
     * @return The order if its found, else null
     */
    public static ArrayList<orders> getAllOrders() {
        return allOrders;
    }

    /**
     * Adds a new customer to the end of the list
     *
     * @param customer The customer object
     */
    public static void addCustomer(customer customer) {
        allCustomers.add(customer);
    }

    /**
     * Gets the specified customer object from the database
     *
     * @return the customer details;
     */
    public static ArrayList<customer> getAllCustomer() {
        return allCustomers;
    }

    // Getters and Setters
    public static ArrayList<bread> getAllBreads() {
        return allBreads;
    }

    public static void setAllBreads(ArrayList<bread> allBreads) {
        pseudoDatabase.allBreads = allBreads;
    }

    public static ArrayList<cake> getAllCakes() {
        return allCakes;
    }

    public static void setAllCakes(ArrayList<cake> allCakes) {
        pseudoDatabase.allCakes = allCakes;
    }

}
