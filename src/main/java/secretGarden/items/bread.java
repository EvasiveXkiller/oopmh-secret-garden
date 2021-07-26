package secretGarden.items;

/**
 * Bread item Class
 */
public class bread extends itemBase {
    private String name;
    private double price;

    public bread(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the bread
     * @return The name of the bread
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the bread
     * @param name The name of the bread
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the bread
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
