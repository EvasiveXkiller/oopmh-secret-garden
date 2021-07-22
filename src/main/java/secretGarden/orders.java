package secretGarden;

import secretGarden.enums.order;
import secretGarden.interfaces.orderInterface;
import secretGarden.items.bread;
import secretGarden.items.cake;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 * Orders class, To be inserted into database
 */
public class orders implements orderInterface {

    private customer owner;
    private String uid;
    private order orderType;
    private String collectionDate;
    private ArrayList<cake> itemCake;
    private ArrayList<bread> itemBread;
    private double totalPrice;

    /**
     * Constructor for preorder
     *
     * @param owner          the owner of the order
     * @param orderType      the type of the order
     * @param collectionDate the collection date of this order
     * @param itemBread      any bread that is ordered
     * @param itemCake       any cake that is ordered
     */
    orders(customer owner, order orderType, String collectionDate, ArrayList<bread> itemBread, ArrayList<cake> itemCake) {
        this.owner = owner;
        this.uid = UUID.randomUUID().toString();
        this.orderType = orderType;
        this.collectionDate = collectionDate;
        this.itemBread = itemBread == null ? new ArrayList<>() : this.itemBread;
        this.itemCake = itemCake == null ? new ArrayList<>() : itemCake;
        this.totalPrice = this.calculateTotal();
        this.calculateMembershipFeatures(true);
    }

    /**
     * Constructor for standard order, cakes are not allowed
     *
     * @param customer  the owner of the order
     * @param orderType the type of the order
     * @param breads    the breads for this order
     */
    orders(customer customer, order orderType, ArrayList<bread> breads) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        this.uid = UUID.randomUUID().toString();
        this.owner = customer;
        this.orderType = orderType;
        this.collectionDate = dtf.format(now);
        this.itemBread = breads;
        this.itemCake = new ArrayList<>();
        this.totalPrice = this.calculateTotal();
        this.calculateMembershipFeatures(false);
    }

    /**
     * Calculates the total price
     *
     * @return The total price of the order
     */
    private double calculateTotal() {
        double tempTotal = 0;
        if (!(itemBread.size() == 0)) {
            for (bread item : Objects.requireNonNull(itemBread)) {
                tempTotal += item.getPrice();
            }
        }
        if (!(itemCake.size() == 0)) {
            for (cake item : itemCake) {
                tempTotal += item.getPrice();
            }
        }
        return tempTotal;
    }

    /**
     * Checks if the member can be premium
     *
     * @param preorder Is the order membership.premium capable?
     */
    private void calculateMembershipFeatures(boolean preorder) {
        if (preorder) owner.setMembershipEligibility(true);
    }

    /**
     * Get total item count
     *
     * @return Total Item Count
     */
    public int getItemCount() {
        return itemCake.size() + itemBread.size();
    }

    // Getter and setters
    public customer getOwner() {
        return owner;
    }

    public void setOwner(customer owner) {
        this.owner = owner;
    }

    public String getUid() {
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

    public ArrayList<cake> getItemCake() {
        return itemCake;
    }

    public void setItemCake(ArrayList<cake> itemCake) {
        this.itemCake = itemCake;
    }

    public ArrayList<bread> getItemBread() {
        return itemBread;
    }

    public void setItemBread(ArrayList<bread> itemBread) {
        this.itemBread = itemBread;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}