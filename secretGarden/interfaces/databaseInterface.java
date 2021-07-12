package secretGarden.interfaces;

import secretGarden.customer;
import secretGarden.orders;

public interface databaseInterface {
    /**
     * Adds a new order to the end of the list
     *
     * @param orders The order to add to the list
     */
    static void addOrder(orders orders) {
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
}
