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
     * Gets the name of cake
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of cake
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get price of cake
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set price of cake
     * @return
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get custom design of cake
     * @return
     */
    public String getCustomDesign() {
        return customDesign;
    }

    /**
     * Set custom design of cake
     * @param customDesign
     */
    public void setCustomDesign(String customDesign) {
        this.customDesign = customDesign;
    }

    /**
     * Get custom candles of cake
     * @return
     */
    public String getCustomCandles() {
        return customCandles;
    }

    /**
     * Set custom candles of cake
     * @param customCandles
     */
    public void setCustomCandles(String customCandles) {
        this.customCandles = customCandles;
    }
}
