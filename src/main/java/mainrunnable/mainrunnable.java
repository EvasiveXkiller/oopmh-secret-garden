package mainrunnable;

import secretGarden.enums.sort;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.orders;
import secretGarden.secretGarden;
import secretGarden.utils.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static secretGarden.utils.utils.stringDateToLocalDateTime;
/**
 * Example of implementation of the code
 */
public class mainrunnable {

    /**
     * Main Method
     *
     * @param args Any arguments
     */
    public static void main(String[] args) {
        secretGarden mainInterface = new secretGarden();
        Scanner secretScanner = new Scanner(System.in);
        int choice1;

        do {
            System.out.println("Welcome to Secret Garden automated ordering system.");
            System.out.println();
            System.out.println("Please enter your phone number.");
            String phoneNum = secretScanner.nextLine();

            if (mainInterface.checkIfCustomerExists(phoneNum)) {
                System.out.println("User found in database, continuing.");
            } else {
                System.out.println();
                System.out.println("Your phone number is not found! Please enter your name to create an account.");
                String customerName = secretScanner.nextLine();
                mainInterface.createNewCustomer(phoneNum, customerName);
            }


            do {
                System.out.println();
                System.out.println("Please choose one of the following:");
                System.out.println();
                System.out.println("1. Place order");
                System.out.println("2. Get status of your order");
                System.out.println("3. Exit program");
                System.out.println("4. Log Out");

                do {
                    choice1 = Integer.parseInt(secretScanner.nextLine());
                    if (choice1 == 1) {
                        System.out.println();
                        System.out.println("What type of order would you like to place?");
                        System.out.println("1. Standard");
                        System.out.println("2. Pre-Order");
                        int choice2;

                        do {
                            choice2 = Integer.parseInt(secretScanner.nextLine());
                            if (choice2 == 1) {
                                ArrayList<bread> temporaryBasket = new ArrayList<>();
                                ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                                int checkOut;
                                int itemIndex;
                                do {

                                    System.out.println();
                                    System.out.println("These are the breads avaliable in our bakery.");
                                    System.out.println();
                                    do {
                                        for (int i = 1; i < itemsFromDB.size(); i++) {
                                            System.out.println("#ID " + i);
                                            System.out.println("Bread: " + itemsFromDB.get(i).getName());
                                            System.out.println("Price: " + itemsFromDB.get(i).getPrice());
                                            System.out.println();
                                        }
                                        System.out.println("You can add these items to the cart. (Please insert the ID)");


                                        itemIndex = Integer.parseInt(secretScanner.nextLine());
                                        if (itemIndex < 1 || itemIndex > 5) {
                                            System.out.println("Bread ID not found! Please try again.");
                                        }
                                    } while (itemIndex < 1 || itemIndex > 5);

                                    System.out.println();
                                    System.out.println("Enter the amount that u want.");
                                    int multiplier = Integer.parseInt(secretScanner.nextLine());

                                    for (int i = 0; i < multiplier; i++) {
                                        temporaryBasket.add(itemsFromDB.get(itemIndex));
                                    }
                                    System.out.println();
                                    System.out.println("These are the things that are in the cart.");
                                    System.out.println();
                                    double temporaryPrice = 0;
                                    for (int i = 0; i < temporaryBasket.size(); i++) {
                                        System.out.println(temporaryBasket.get(i).getName());
                                        System.out.println("Price: RM " + temporaryBasket.get(i).getPrice());
                                        System.out.println();
                                        temporaryPrice += temporaryBasket.get(i).getPrice();
                                    }
                                    System.out.println("Total RM " + temporaryPrice);
                                    System.out.println();
                                    System.out.println("Continue to checkout?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    checkOut = Integer.parseInt(secretScanner.nextLine());

                                    if (checkOut == 1) {
                                        String orderID = mainInterface.placeOrders(
                                                mainInterface.getCustomer(phoneNum),
                                                temporaryBasket
                                        );

                                        orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                        double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                        System.out.println();
                                        System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                                        System.out.println();
                                        System.out.println("Total Price: RM " + priceAfterTax);
                                        System.out.println("Order ID: " + orderID);
                                    } else {
                                        System.out.println();
                                        System.out.println("Returning");
                                    }
                                } while (checkOut != 1);
                            } else if (choice2 == 2) {
                                int itemIndex;
                                System.out.println("You have chosen pre-order. " +
                                        "Are you interested in our selection of cakes or breads? " +
                                        "1 for Bread, " +
                                        "2 for Cakes");
                                int preorder = Integer.parseInt(secretScanner.nextLine());
                                if (preorder == 1) {
                                    ArrayList<bread> temporaryBasket = new ArrayList<>();
                                    ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                                    int checkOut2;

                                    do {
                                        System.out.println();
                                        System.out.println("These are the breads that are available in our bakery.");
                                        System.out.println();
                                        do {
                                            for (int i = 1; i < itemsFromDB.size(); i++) {
                                                System.out.println("#ID " + i);
                                                System.out.println("Bread: " + itemsFromDB.get(i).getName());
                                                System.out.println("Price: " + itemsFromDB.get(i).getPrice());
                                                System.out.println();
                                            }
                                            System.out.println("You can add these items to the cart. (Please insert the ID)");
                                            itemIndex = Integer.parseInt(secretScanner.nextLine());
                                            if (itemIndex < 1 || itemIndex > 5) {
                                                System.out.println("Bread ID not found! Please try again.");
                                            }
                                        } while (itemIndex < 1 || itemIndex > 5);
                                        System.out.println();
                                        System.out.println("Enter the amount that u want.");
                                        int multiplier = Integer.parseInt(secretScanner.nextLine());

                                        for (int i = 0; i < multiplier; i++) {
                                            temporaryBasket.add(itemsFromDB.get(itemIndex));
                                        }
                                        System.out.println();
                                        System.out.println("These are the things that are in the cart.");
                                        System.out.println();

                                        double temporaryPrice = 0;
                                        for (int i = 0; i < multiplier; i++) {
                                            System.out.println(temporaryBasket.get(i).getName());
                                            System.out.println("Price: RM " + temporaryBasket.get(i).getPrice());
                                            System.out.println();
                                            temporaryPrice += temporaryBasket.get(i).getPrice();
                                        }
                                        System.out.println("Total RM " + temporaryPrice);
                                        System.out.println();
                                        System.out.println("Continue to checkout?");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        checkOut2 = Integer.parseInt(secretScanner.nextLine());

                                        if (checkOut2 == 1) {
                                            System.out.println();
                                            System.out.println("Enter a date collection for your pre-order. (dd/MM/yyy) eg. 08/08/2021");
                                            String scollectionDate;
                                            scollectionDate = secretScanner.nextLine();
                                            LocalDateTime actualOrderDate = stringDateToLocalDateTime(scollectionDate);
                                            String orderID = mainInterface.placeOrders(
                                                    mainInterface.getCustomer(phoneNum),
                                                    actualOrderDate,
                                                    temporaryBasket,
                                                    null
                                            );
                                            orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                            if (CurOrder.getTotalPrice() > 100) {
                                                System.out.println("You are entitled to receive a free gift!");
                                            }

                                            double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                            System.out.println();
                                            System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                                            System.out.println();
                                            System.out.println("Total Price: RM " + priceAfterTax);
                                            System.out.println("Order ID: " + orderID);
                                            System.out.println("Collection Date: " + actualOrderDate);
                                        } else {
                                            System.out.println("Returning...");
                                        }
                                    } while (checkOut2 != 1);
                                }

                                if (preorder == 2) {
                                    int cakeIndex;
                                    ArrayList<cake> cakeFromDB = mainInterface.getAllCakesItems();
                                    System.out.println("These are the cakes available currently.");
                                    System.out.println();
                                    do {
                                        for (int i = 1; i < cakeFromDB.size(); i++) {
                                            System.out.println("#ID " + i);
                                            System.out.println("Cake:" + cakeFromDB.get(i).getName());
                                            System.out.println("Price: RM " + cakeFromDB.get(i).getPrice());
                                            System.out.println();
                                        }
                                        System.out.println();
                                        System.out.println("Which cake are you interested in? (Please insert the ID)");
                                        cakeIndex = Integer.parseInt(secretScanner.nextLine());
                                        if (cakeIndex < 1 || cakeIndex > 3) {
                                            System.out.println("Cake ID not found! Please try again.");
                                        }
                                    } while (cakeIndex < 1 || cakeIndex > 3);
                                    cake currentOrder = new cake(
                                            cakeFromDB.get(cakeIndex).getName(),
                                            cakeFromDB.get(cakeIndex).getPrice()
                                    );

                                    int addon;
                                    do {
                                        System.out.println();
                                        System.out.println("Are you interested in our add-on services (custom design & custom candles)?");
                                        System.out.println("1. YES");
                                        System.out.println("2. NO");
                                        addon = Integer.parseInt(secretScanner.nextLine());
                                        if (addon == 1) {
                                            System.out.println();
                                            System.out.println("Please describe the design of the cake. (Icing decoration, etc.)");
                                            String customDesign = secretScanner.nextLine();
                                            currentOrder.setCustomDesign(customDesign);

                                            System.out.println();
                                            System.out.println("Please describe the candle of the cake. (Number of candles, shape, colour, etc.)");
                                            String customCandles = secretScanner.nextLine();
                                            currentOrder.setCustomCandles(customCandles);

                                            System.out.println();
                                            System.out.println("Continuing to checkout.");
                                            ArrayList<cake> cakeOrder = new ArrayList<>();
                                            cakeOrder.add(currentOrder);
                                            System.out.println();
                                            System.out.println("Enter a date collection for your pre-order. (dd/MM/yyy) eg. 08/08/2021");
                                            String scollectionDate;
                                            scollectionDate = secretScanner.nextLine();
                                            LocalDateTime actualOrderDate = stringDateToLocalDateTime(scollectionDate);
                                            String orderID = mainInterface.placeOrders(
                                                    mainInterface.getCustomer(phoneNum),
                                                    actualOrderDate,
                                                    null,
                                                    cakeOrder
                                            );
                                            orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                            double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                            System.out.println();
                                            System.out.println("Your order is successfully placed! Thank you for shopping at Secret Garden!");
                                            System.out.println();
                                            System.out.println("Total Price: RM " + priceAfterTax);
                                            System.out.println("Order ID: " + orderID);
                                            System.out.println("Design: " + customDesign);
                                            System.out.println("Candles: " + customCandles);
                                            System.out.println("Collection Date: " + actualOrderDate);
                                        }

                                        else if (addon == 2) {
                                            System.out.println();
                                            System.out.println("Continuing to checkout.");
                                            ArrayList<cake> cakeOrder = new ArrayList<>();
                                            cakeOrder.add(currentOrder);
                                            System.out.println();
                                            System.out.println("Enter a date collection for your pre-order. (dd/MM/yyy) eg. 08/08/2021");
                                            String scollectionDate;
                                            scollectionDate = secretScanner.nextLine();
                                            LocalDateTime actualOrderDate = stringDateToLocalDateTime(scollectionDate);
                                            String orderID = mainInterface.placeOrders(
                                                    mainInterface.getCustomer(phoneNum),
                                                    actualOrderDate,
                                                    null,
                                                    cakeOrder
                                            );
                                            orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                            double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                            System.out.println();
                                            System.out.println("Your order is successfully placed! Thank you for shopping at Secret Garden!");
                                            System.out.println();
                                            System.out.println("Total Price: RM " + priceAfterTax);
                                            System.out.println("Order ID: " + orderID);
                                            System.out.println("Collection Date: " + actualOrderDate);
                                        } else {
                                            System.out.println();
                                            System.out.println("You have chosen an invalid response. Please try again.");
                                        }
                                    } while (addon != 1 && addon != 2);
                                }
                            } else {
                                System.out.println();
                                System.out.println("You have chosen an invalid response. Please try again.");
                            }
                        } while (choice2 != 1 && choice2 != 2);

                    } else if (choice1 == 2) {
                        System.out.println();
                        System.out.println("1 - Would you like to see the status of one order?");
                        System.out.println("2 - Would you like to see the status of all your order?");
                        int show = Integer.parseInt(secretScanner.nextLine());


                        if (show == 1) {
                            String OrderID;
                            ArrayList<orders> tempList = new ArrayList<>();
                            System.out.println();
                            System.out.println("Please enter the order ID of the order that you want to check.");
                            OrderID = secretScanner.nextLine();
                            orders single = mainInterface.getThisCustomerOrderSingle(OrderID);
                            if (single == null) {
                                System.out.println();
                                System.out.println("Order Not Found!");
                            } else {
                                tempList.add(single);
                                showAllOrders(tempList);
                            }
                        }

                        if (show == 2) {
                            int sortChoice;
                            do {
                                System.out.println();
                                System.out.println();
                                System.out.println("How would you like to sort your orders?");
                                System.out.println();
                                System.out.println("1. Order Date");
                                System.out.println("2. Order Type");
                                System.out.println("3. Amount of items");
                                System.out.println("4. Order price");
                                sortChoice = Integer.parseInt(secretScanner.nextLine());
                                if (sortChoice == 1) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.DATE);
                                    showAllOrders(sorted);
                                } else if (sortChoice == 2) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.TYPE);
                                    showAllOrders(sorted);
                                } else if (sortChoice == 3) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.AMOUNT_OF_ITEMS);
                                    showAllOrders(sorted);
                                } else if (sortChoice == 4) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.ORDER_PRICE);
                                    showAllOrders(sorted);
                                }

                            } while (sortChoice != 1 && sortChoice != 2 && sortChoice != 3 && sortChoice != 4);
                        }

                    } else if (choice1 == 3) {
                        System.out.println();
                        System.out.println("Thank you for shopping at Secret Garden!");
                        secretScanner.close();
                        System.exit(0);
                    } else if (choice1 == 4) {
                        System.out.println();
                        System.out.println("Logging out. Thank you for shopping at Secret Garden!");
                        break;
                    } else {
                        System.out.println();
                        System.out.println("You have chosen an invalid response. Please try again.");
                    }

                } while (choice1 != 1 && choice1 != 2);

            } while (choice1 != 4);

        } while (true);

    }

    /**
     * Show all the orders fragment code, repeating code
     *
     * @param sorted The sorted list of the order
     */
    private static void showAllOrders(ArrayList<orders> sorted) {
        for (orders orderList : sorted) {
            System.out.println("Order ID : " + orderList.getUid());
            System.out.println("Total Price : " + orderList.getTotalPrice());
            System.out.println("Total Items : " + orderList.getItemCount());
            System.out.println("Items in order");
            for (int i = 0; i < orderList.getItemBread().size(); i++) {
                System.out.println("Item name : " + orderList.getItemBread().get(i).getName());
                System.out.println("Item price: " + orderList.getItemBread().get(i).getPrice());
            }
            for (int i = 0; i < orderList.getItemCake().size(); i++) {
                System.out.println("Item name : " + orderList.getItemCake().get(i).getName());
                System.out.println("Item price: " + orderList.getItemCake().get(i).getPrice());
                System.out.println("Designs : " + orderList.getItemCake().get(i).getCustomDesign());
                System.out.println("Candles : " + orderList.getItemCake().get(i).getCustomCandles());
            }
            System.out.println();
        }
    }
}