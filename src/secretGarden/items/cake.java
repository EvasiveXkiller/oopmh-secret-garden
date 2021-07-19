package secretGarden.items;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomDesign() {
        return customDesign;
    }

    public void setCustomDesign(String customDesign) {
        this.customDesign = customDesign;
    }

    public String getCustomCandles() {
        return customCandles;
    }

    public void setCustomCandles(String customCandles) {
        this.customCandles = customCandles;
    }
}
