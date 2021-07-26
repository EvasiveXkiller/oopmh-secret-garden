package secretGarden.items;

/**
 * Base class for all items, if needed
 */
abstract class itemBase {
    private String name;
    private double price;

    /**
     * Gets the name of the product
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product
     * @param name The name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of the product
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product
     * @param price The price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
