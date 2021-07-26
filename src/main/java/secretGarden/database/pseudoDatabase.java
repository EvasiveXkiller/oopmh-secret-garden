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
    private static ArrayList<bread> allBreads = new ArrayList<>();
    private static ArrayList<cake> allCakes = new ArrayList<>();
    private static final ArrayList<orders> allOrders = new ArrayList<>();
    private static final ArrayList<customer> allCustomers = new ArrayList<>();
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

    /**
     * Set all the breads in the database
     * @param allBreads The list of breads
     */
    public static void setAllBreads(ArrayList<bread> allBreads) {
        pseudoDatabase.allBreads = allBreads;
    }

    /**
     * Get all the cakes from the database
     * @return arraylist of cakes
     */
    public static ArrayList<cake> getAllCakes() {
        return allCakes;
    }

    /**
     * Set all the cakes in the database
     * @param allCakes The list of cakes
     */
    public static void setAllCakes(ArrayList<cake> allCakes) {
        pseudoDatabase.allCakes = allCakes;
    }

}
