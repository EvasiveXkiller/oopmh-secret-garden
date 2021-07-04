package secretGarden;

import secretGarden.enums.membership;
import secretGarden.enums.order;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.UUID;

public class orders {
    private customer owner;
    private String uid;
    private order orderType;
    private String collectionDate;
    private Object items;

    orders(customer owner, order orderType, String collectionDate, Object items) {
        this.owner = owner;
        this.uid = UUID.randomUUID().toString();
        this.orderType = orderType;
        this.collectionDate = collectionDate;
        this.items = items;
        this.calculateMembershipFeatures(true);
    }

    orders(order orderType, Object items) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.uid = UUID.randomUUID().toString();
        this.orderType = orderType;
        this.collectionDate = dtf.format(now);
        this.items = items;
        this.calculateMembershipFeatures(false);
    }

    private void calculateMembershipFeatures(boolean preorder) {
        if (preorder) owner.setMembershipEligibility(true);
    }

    public String getUUID() {
        return uid;
    }

    public void setUUID(String UUID) {
        this.uid = UUID;
    }

    public order getOrderType() {
        return orderType;
    }

    public void setOrderType(order orderType) {
        this.orderType = orderType;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public order getorderType() {
        return orderType;
    }

    public void setorderType(order orderType) {
        this.orderType = orderType;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }
}