package secretGarden.utils;

import secretGarden.orders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Comparator;

public class utils {
    /**
     * Calculates the tax price
     *
     * @param rate           The rate of the tax. Eg. 0.06 is 6%, 0.20 is 20%
     * @param beforeTaxPrice The price before the inclusion of tax
     * @return The calculated tax price
     */
    public static double calculateTax(double rate, double beforeTaxPrice) {
        return (rate * beforeTaxPrice) + beforeTaxPrice;
    }
    // TODO write comments

    /**
     * @param orders
     * @return
     */
    public static ArrayList<orders> sortOrderByDate(ArrayList<orders> orders) {
        orders.sort((order1, order2) -> {
            // TODO Auto-generated method stub
            String date1 = order1.getCollectionDate();
            String date2 = order2.getCollectionDate();

            String day1 = date1.substring(0, 2);
            String month1 = date1.substring(3, 5);
            String year1 = date1.substring(6);

            String day2 = date2.substring(0, 2);
            String month2 = date2.substring(3, 5);
            String year2 = date2.substring(6);

            // Condition to check the year
            if (year2.compareTo(year1) > 0) {
                return -1;
            } else if (year2.compareTo(year1) < 0) {
                return 1;
            }

            // Condition to check the month
            else if (month2.compareTo(month1) > 0) {
                return -1;
            } else if (month2.compareTo(month1) < 0) {
                return 1;
            }

            // Condition to check the day
            else if (day2.compareTo(day1) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        return orders;
    }

    public static ArrayList<orders> sortOrderByItems(ArrayList<orders> orders) {
        orders.sort(Comparator.comparingInt(secretGarden.orders::getItemCount));
        return orders;
    }

    public static ArrayList<orders> sortOrderByPrice(ArrayList<orders> orders) {
        orders.sort(Comparator.comparingDouble(secretGarden.orders::getTotalPrice));
        return orders;
    }

    public static ArrayList<orders> sortOrderByType(ArrayList<orders> orders) {
        orders.sort(Comparator.comparing(secretGarden.orders::getOrderType));
        return orders;
    }


    public static LocalDateTime stringDateToLocalDateTime(String stringDate) {
        String date = stringDate.replace("-", "/");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        dateTimeFormatter = dateTimeFormatter.withResolverStyle(ResolverStyle.STRICT);
        LocalDate unparsedTime = LocalDate.parse(date, dateTimeFormatter);
        LocalDateTime convertedDate = unparsedTime.atStartOfDay();
        return convertedDate;
    }

}



