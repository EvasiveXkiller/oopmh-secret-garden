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
    private membership memberStatus;
    private Date expirationDate;

   
    customer(String customerID, membership memberStatus, Date expirationDate) {
        this.customerID = customerID;
        this.memberStatus = memberStatus;
        this.expirationDate = expirationDate;
    }

    @Override
    public customer getCustomerInfo(String uid) {
        // TODO database callback to get only this customer out
    	
    	System.out.println("Enter customer ID you want to find:");
        customer Customer = getCustomerInfo(uid);
        
        for(customer Customer : customerID) {
            if (Customer.getCustomerInfo(uid).equals(uid) ) {
                return Customer;
            }
        }
        return null;
    }   
        
   	
    	
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