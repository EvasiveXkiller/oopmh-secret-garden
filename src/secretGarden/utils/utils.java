package secretGarden.utils;

public class utils {
    /**
     * Calculates the tax price
     * @param rate The rate of the tax. Eg. 0.06 is 6%, 0.20 is 20%
     * @param beforeTaxPrice The price before the inclusion of tax
     * @return The calculated tax price
     */
    public static double calculateTax(double rate, double beforeTaxPrice) {
        return (rate * beforeTaxPrice) + beforeTaxPrice;
    }
}
