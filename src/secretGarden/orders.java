package secretGarden;

import secretGarden.enums.order;
import secretGarden.items.bread;
import secretGarden.items.cake;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class orders {

    class orderWrapper {
        public cake cakeItem;
        public bread breadItem;
    }


    private customer owner;
    private String uid;
    private order orderType;
    private String collectionDate;
    private ArrayList<orders, cake> items;
    private double price;


    public customer getOwner() {
        return owner;
    }

    public void setOwner(customer owner) {
        this.owner = owner;
    }

    /**
     * Pre Order
     *
     * @param owner
     * @param orderType
     * @param collectionDate
     * @param items
     */
    orders(customer owner, order orderType, String collectionDate, ArrayList items) {
        this.owner = owner;
        this.uid = UUID.randomUUID().toString();
        this.orderType = orderType;
        this.collectionDate = collectionDate;
        this.items = items;
        this.price = this.calculateTotal();
        this.calculateMembershipFeatures(true);
    }

    /**
     * Standard Order
     *
     * @param customer
     * @param orderType
     * @param items
     */
    orders(customer customer, order orderType, ArrayList items) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        this.uid = UUID.randomUUID().toString();
        this.owner = customer;
        this.orderType = orderType;
        this.collectionDate = dtf.format(now);
        this.items = items;
        this.price = this.calculateTotal();
        this.calculateMembershipFeatures(false);
    }

    private double calculateTotal() {
        double tempTotal = 0;
        for (Object item : items) {
            tempTotal += item.getPrice();
        }
        return tempTotal;
    }

    private void calculateMembershipFeatures(boolean preorder) {
        if (preorder) owner.setMembershipEligibility(true);
    }

    public String getUUID() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public order getOrderType() {
        return orderType;
    }

    public void setOrderType(order orderType) {
        this.orderType = orderType;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public double getPrice() {
        return this.price;
    }
}