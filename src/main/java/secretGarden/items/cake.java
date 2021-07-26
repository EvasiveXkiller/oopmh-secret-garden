package secretGarden.items;

/**
 * Cake item Class
 */
public class cake extends itemBase {
    private String name;
    private double price;
    private String customDesign;
    private String customCandles;

    public cake(String name, double price) {
        this.name = name;
        this.price = price;
        this.customDesign = "";
        this.customCandles = "";
    }

    /**
     * Gets the name of the cake
     * @return The name of the cake
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of cake
     * @param name The name of bread
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get price of the product
     * @return The price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of the productcake
     * @param price The price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get custom design of the cake
     * @return The custom design of the cake
     */
    public String getCustomDesign() {
        return customDesign;
    }

    /**
     * Set custom design of cake
     * @param customDesign The custom design of the cake
     */
    public void setCustomDesign(String customDesign) {
        this.customDesign = customDesign;
    }

    /**
     * Get custom candles of cake
     * @return The custom candles of cake
     */
    public String getCustomCandles() {
        return customCandles;
    }

    /**
     * Set custom candles of cake
     * @param customCandles The custom candles of cake
     */
    public void setCustomCandles(String customCandles) {
        this.customCandles = customCandles;
    }
}
