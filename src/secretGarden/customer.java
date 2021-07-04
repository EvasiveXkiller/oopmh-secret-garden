package secretGarden;

import secretGarden.enums.membership;
import secretGarden.interfaces.customerInterface;

import java.util.Date;

public class customer implements customerInterface {
    private String customerID;
    private membership memberStatus;
    private int expirationDate;

    class customerInfo {
        private String customerID;

    }

    customer(String customerID, membership memberStatus, int expirationDate) {
        this.customerID = customerID;
        this.memberStatus = memberStatus;
        this.expirationDate = expirationDate;
    }

    @Override
    public customer getCustomerInfo(String uid) {
        // TODO database callback to get only this customer out
        return null;
    }

    public void setMembershipEligibility(boolean eligible) {
        this.memberStatus = eligible ? membership.ELIGIBLE : membership.STANDARD;
    }

    @Override
    public Date updateMembershipStatus() {
        return null;
    }
}