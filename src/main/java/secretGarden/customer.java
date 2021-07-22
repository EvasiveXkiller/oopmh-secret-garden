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

    // Getters and Setters
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public membership getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(membership memberStatus) {
        this.memberStatus = memberStatus;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

}