package secretGarden;

import secretGarden.enums.membership;
import secretGarden.interfaces.customerInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class customer {
    private String customerID;
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private membership memberStatus;
    private Date expirationDate;

    customer(String customerID, String customerName, membership memberStatus) {
        Date date = new Date();
        this.customerName = customerName;
        this.customerID = customerID;
        this.memberStatus = memberStatus;
        this.expirationDate = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public membership getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(membership memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setMembershipEligibility(boolean eligible) {
        this.memberStatus = eligible ? membership.ELIGIBLE : membership.STANDARD;
    }

    public Date updateMembershipStatus() {
        return null;
    }
}