package secretGarden;

import secretGarden.enums.membership;
import secretGarden.interfaces.customerInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class customer implements customerInterface {
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

//    @Override
//    public customer getCustomerInfo(String uid) {
//        // TODO database callback to get only this customer out
//
//    	System.out.println("Enter customer ID you want to find:");
//        customer Customer = getCustomerInfo(uid);
//
//        for(customer Customer : customerID) {
//            if (Customer.getCustomerInfo(uid).equals(uid) ) {
//                return Customer;
//            }
//        }
//        return null;
//    }


    /*	Can use for other part
             private List <customer> customers;

            SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
            Date temp;

            if(customers.size() > 1) {
                boolean fixed=false;

                while (fixed=false)	{
                    for(int i=0; i < customers.size()-1; i++) {
                        fixed = true;

                        Date date1 = customers.get(i).expirationDate;
                        Date date2 = customers.get(i+1).expirationDate;

                        if((date1).after(date2)) {
                            temp=customers.get(i+1).expirationDate;
                            customers.get(i+1).expirationDate = customers.get(i).expirationDate;
                            customers.get(i).expirationDate = expirationDate;

                    fixed=false;
                        }
                    }
                }
            }

            for(int i=0; i<customers.size(); i++) {

                System.out.println(i+"customers.get(i).customerID+");
            }
            return null;
        }

    */
    public void setMembershipEligibility(boolean eligible) {
        this.memberStatus = eligible ? membership.ELIGIBLE : membership.STANDARD;
    }

    @Override
    public Date updateMembershipStatus() {
        return null;
    }
}