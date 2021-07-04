package secretGarden.interfaces;

import secretGarden.customer;

import java.util.Date;

public interface customerInterface {
    /**
     * Get the customer Information
     * @param uid The customer's id [phone number in this case]
     * @return customer object
     */
    customer getCustomerInfo(String uid);

    /**
     * Updates the membership status, will set the expiration date to next 2 years automatically
     * @return Date object of expiration Date;
     */
    Date updateMembershipStatus();
}
