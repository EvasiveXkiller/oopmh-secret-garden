package secretGarden;

import secretGarden.enums.membership;

import java.time.LocalDateTime;

public class customer {
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

    public LocalDateTime updateMembershipStatus() {
        LocalDateTime actualDateTime = LocalDateTime.now();
        this.expirationDate = actualDateTime.plusYears(2);
        return expirationDate;
    }

    public void setMembershipEligibility(boolean eligible) {
        this.memberStatus = eligible ? membership.ELIGIBLE : membership.STANDARD;
    }

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