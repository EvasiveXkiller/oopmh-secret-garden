public class customer {
    private String customerID;
    private String memberStatus;
    private int expirationDate;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    customer(String customerID, String memberStatus, int expirationDate){
        this.customerID = customerID;
        this.memberStatus = memberStatus;
        this.expirationDate = expirationDate;
    }


}