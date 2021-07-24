package secretGarden.interfaces;

import secretGarden.customer;
import secretGarden.enums.sort;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.orders;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interface for the main Interface
 */
public interface webInterface {
    /**
     * Places a new order, Pre Order type
     *
     * @param customer       the customer that owns this order
     * @param collectionDate the collection date
     * @param itemBread      any bread items
     * @param itemCake       any cake items
     * @return the order ID
     */
    String placeOrders(customer customer, LocalDateTime collectionDate, ArrayList<bread> itemBread, ArrayList<cake> itemCake);

    /**
     * Places a new order, Standard type
     *
     * @param customer the customer that owns this order
     * @param items    the bread items in the order
     * @return the order iD
     */
    String placeOrders(customer customer, ArrayList<bread> items);

    /**
     * Checks if the customer is in the database
     *
     * @param phoneNum Phone number as ID
     * @return If the customer exists
     */
    boolean checkIfCustomerExists(String phoneNum);

    /**
     * Creates a new customer,
     *
     * @param phoneNum Using phone number as an ID
     * @param name     Name of the customer
     */
    void createNewCustomer(String phoneNum, String name);

    /**
     * Gets the customer object from the database
     *
     * @param phoneNum the ID of the customer to get
     * @return the customer object
     */
    customer getCustomer(String phoneNum);

    /**
     * Gets all the orders of a specific customer
     *
     * @param phoneNum   the id of the customer
     * @param sortMethod the sort method
     * @return an arraylist of orders
     */
    ArrayList<orders> getThisCustomerOrder(String phoneNum, sort sortMethod);

    /**
     * Gets a single order based on the order ID
     *
     * @param ID the order ID
     * @return the order
     */
    orders getThisCustomerOrderSingle(String ID);
}
