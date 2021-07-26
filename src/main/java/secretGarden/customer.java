package secretGarden;

import secretGarden.enums.membership;
import secretGarden.interfaces.customerInterface;

import java.time.LocalDateTime;

/**
 * Customer class to hold customer details
 */
public class customer implements customerInterface {
    private String customerID;
    private String customerName;
    private membership memberStatus;
    private LocalDateTime expirationDate;
/**
 * Constructor for customer
 * 
 * @param customerID    The ID given to the customer
 * @param customerName  The name inputted by the customer
 * @param memberStatus  Refer to the membership status in enums 
 * 
 */
    customer(String customerID, String customerName, membership memberStatus) {
        LocalDateTime now = LocalDateTime.now();
        this.customerName = customerName;
        this.customerID = customerID;
        this.memberStatus = memberStatus;
        this.expirationDate = now;
    }

    /**
     * Updates the membership, date is set to today
     *
     * @return The next expiration date
     */
    public LocalDateTime updateMembershipStatus() {
        this.memberStatus = membership.PREMIUM;
        LocalDateTime actualDateTime = LocalDateTime.now();
        this.expirationDate = actualDateTime.plusYears(2);
        return expirationDate;
    }

    /**
     * Sets if the user can be premium
     *
     * @param eligible set to true if eligible
     */
    public void setMembershipEligibility(boolean eligible) {
        this.memberStatus = eligible ? membership.ELIGIBLE : membership.STANDARD;
    }

    /**
     * Gets the ID from a customer
     * 
     * @return the customer ID 
     */
    public String getCustomerID() {
        return customerID;
    }
    /**
     * Sets the ID of a customer
     * @param customerID The ID of the customer
     * 
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    /**
     * Gets the name of the customer
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Sets the name of the customer
     * @param customerName The name of the customer
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * Gets the membership status of the member
     * @return the membership status
     */
    public membership getMemberStatus() {
        return memberStatus;
    }
    /**
     * Sets the membership status of the member
     * @param memberStatus The membership status of the customer
     */
    public void setMemberStatus(membership memberStatus) {
        this.memberStatus = memberStatus;
    }
    /**
     * Gets the expiration date of the membership
     * @return the expiration date
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
    /**
     * Sets the expiration date
     * @param expirationDate the expiration date of the membership status
     */
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

}