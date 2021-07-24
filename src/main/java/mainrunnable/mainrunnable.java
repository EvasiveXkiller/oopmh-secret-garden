package mainrunnable;

import secretGarden.*;
import secretGarden.enums.sort;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.utils.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/*
TODO probably replace all scanners with nextline(), might produce numberformatexception if entered chars, and auto nextLine, see line 205
TODO switching of user


DONE make bread price more sensible

TODO more testing
 */

public class mainrunnable {

    public static void main(String[] args) {
        secretGarden mainInterface = new secretGarden();
        Scanner secretScanner = new Scanner(System.in);
        int choice1;

        do {
            System.out.println("Welcome to Secret Garden automated ordering system.");
            System.out.println("Please enter your phone number.");
            String phoneNum = secretScanner.nextLine();

            if (mainInterface.checkIfCustomerExists(phoneNum)) {
                System.out.println("User found in database, continuing.");
            } else {
                System.out.println("Your phone number is not found! Please enter your name to create an account.");
                String customerName = secretScanner.nextLine();
                mainInterface.createNewCustomer(phoneNum, customerName);
            }


            do {
                System.out.println("");
                System.out.println("Please choose one of the following:");
                System.out.println("1. Place order");
                System.out.println("2. Get status of your order");
                System.out.println("3. Exit program");
                System.out.println("4. Log Out");
                // TODO Jun add a method to switch user.

                do {
                    choice1 = secretScanner.nextInt();
                    if (choice1 == 1) {
                        System.out.println("What type of order would you like to place?");
                        System.out.println("1. Standard");
                        System.out.println("2. Pre-Order");
                        int choice2;

                        do {
                            choice2 = secretScanner.nextInt();
                            if (choice2 == 1) {
                                ArrayList<bread> temporaryBasket = new ArrayList<>();
                                ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                                //TODO while loop starts here !important
                                int checkOut;
                                do {
                                    System.out.println("These are the breads avaliable in our bakery.");
                                    for (int i = 0; i < itemsFromDB.size(); i++) {
                                        //TODO Jun id added ,probably better formatting
                                        System.out.println("#ID " + i);
                                        System.out.println("Bread:" + itemsFromDB.get(i).getName());
                                        System.out.println("Price:" + itemsFromDB.get(i).getPrice());
                                    }
                                    System.out.println("You can add these items to the cart.");
                                    int itemIndex = secretScanner.nextInt();
                                    // TODO check if the bread id actually exist, might product indexoutofbounds if not handled
                                    System.out.println("Enter the amount that u want to for this item."); //TODO replace "this item" with more descriptive text
                                    int multiplier = secretScanner.nextInt();

                                    for (int i = 0; i < multiplier; i++) {
                                        temporaryBasket.add(itemsFromDB.get(itemIndex));
                                    }


                                    // TODO Jun only 1 bread can be added now, need a loop here to fix it (should be solved)
                                    System.out.println("Theses thing are in the cart.");

                                    double temporaryPrice = 0;
                                    // TODO add temporary price to all the below
                                    for (int i = 0; i < temporaryBasket.size(); i++) {
                                        // TODO Jun did the price thingy, check plz
                                        System.out.println(temporaryBasket.get(i).getName());
                                        System.out.println("Price:" + temporaryBasket.get(i).getPrice());
                                        temporaryPrice += temporaryBasket.get(i).getPrice();
                                    }
                                    System.out.println(temporaryPrice);

                                    System.out.println("Continue to checkout?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    checkOut = secretScanner.nextInt();

                                    if (checkOut == 1) {
                                        String orderID = mainInterface.placeOrders(
                                                mainInterface.getCustomer(phoneNum),
                                                temporaryBasket
                                        );
                                        // Supposed to be the order UUID here, not the phone number
                                        orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                        double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                        System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                                        System.out.println("Total Price: RM" + priceAfterTax);
                                        System.out.println("Order ID:" + orderID);
                                    } else {
                                        System.out.println("Returning");
                                    }
                                } while (checkOut != 1);
                            } else if (choice2 == 2) {
                                System.out.println("You have chosen pre-order. " +
                                        "Are you interested in our selection of cakes or breads? " +
                                        "1 for Bread, " +
                                        "2 for Cakes");
                                int preorder = secretScanner.nextInt();
                                if (preorder == 1) {
                                    ArrayList<bread> temporaryBasket = new ArrayList<>();
                                    ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                                    int checkOut2;
                                    //TODO while loop starts here !important
                                    do {
                                        System.out.println("These are the breads in our bakery.");
                                        for (int i = 0; i < itemsFromDB.size(); i++) {
                                            // TODO Jun did the price thingy, check plz
                                            System.out.println("#ID " + i);
                                            System.out.println("Bread:" + itemsFromDB.get(i).getName());
                                            System.out.println("Price:" + itemsFromDB.get(i).getPrice());
                                        }
                                        System.out.println("You can add these items to the cart.");
                                        int itemIndex = secretScanner.nextInt();
                                        System.out.println("Enter the amount that u want to for this item.");
                                        int multiplier = secretScanner.nextInt();

                                        // TODO check if the bread id actually exist, might product indexoutofbounds if not handled
                                        for (int i = 0; i < multiplier; i++) {
                                            temporaryBasket.add(itemsFromDB.get(itemIndex));
                                        }

                                        // TODO Jun loop back, only can add 1 item into cart for now.(solved)
                                        System.out.println("Theses thing are in the cart");

                                        // TODO Juni think u missed the UI print here(solved)
                                        double temporaryPrice = 0;
                                        for (int i = 0; i < multiplier; i++) {
                                            System.out.println(temporaryBasket.get(i).getName());
                                            System.out.println("Price:" + temporaryBasket.get(i).getPrice());
                                            temporaryPrice += temporaryBasket.get(i).getPrice();
                                        }
                                        System.out.println(temporaryPrice);

                                        System.out.println("Continue to checkout?");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        checkOut2 = secretScanner.nextInt();

                                        if (checkOut2 == 1) {
                                            // TODO i think u forgotten to add the date in the UI, preorder collection date cant be today
                                            String orderID = mainInterface.placeOrders(
                                                    mainInterface.getCustomer(phoneNum),
                                                    LocalDateTime.now(),
                                                    temporaryBasket,
                                                    null
                                            );
                                            // Same thing here, function takes in UUID not phone number, fixed
                                            orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                            if (CurOrder.getTotalPrice() > 100) {
                                                System.out.println("You are entitled to receive a free gift!");
                                            }

                                            double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                            System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                                            // TODO add calculate price here
                                            System.out.println("Total Price: RM" + priceAfterTax);
                                            System.out.println("Order ID:" + orderID);
                                            // TODO Jun dont exit the program here i guess, let it return to the main menu
                                        } else {
                                            System.out.println("Returning...");
                                        }
                                    } while (checkOut2 != 1);
                                }

                                if (preorder == 2) {
                                    ArrayList<cake> cakeFromDB = mainInterface.getAllCakesItems();
                                    System.out.println("These are the cakes available right now.");
                                    for (int i = 0; i < cakeFromDB.size(); i++) {
                                        // TODO Jun did the price thingy, check plz
                                        System.out.println("#ID " + i);
                                        System.out.println("Cake:" + cakeFromDB.get(i).getName());
                                        System.out.println("Price:" + cakeFromDB.get(i).getPrice());
                                    }
                                    System.out.println("Which cake are you interested in?");
                                    int cakeIndex = secretScanner.nextInt();
                                    cake currentOrder = new cake(
                                            cakeFromDB.get(cakeIndex).getName(),
                                            cakeFromDB.get(cakeIndex).getPrice()
                                    );

                                    int addon;
                                    do {
                                        System.out.println("Are you interested in our add-on services (custom design & custom candles)?");
                                        System.out.println("1. YES");
                                        System.out.println("2. NO");
                                        addon = secretScanner.nextInt();
                                        if (addon == 1) {
                                            // TODO UI
                                            System.out.println("Please describe the design of the cake. (Icing decoration, etc.)");
                                            // TODO nextLine here will just fly by as \n is still in stdin
                                            String customDesign = secretScanner.nextLine();
                                            currentOrder.setCustomDesign(customDesign);

                                            // TODO same here
                                            System.out.println("Please describe the candle of the cake. (Number of candles, shape, colour, etc.)");
                                            String customCandles = secretScanner.nextLine();
                                            currentOrder.setCustomCandles(customCandles);
                                        }

                                        if (addon == 2) {
                                            //TODO print the things out
                                            System.out.println("Continuing to checkout.");
                                            ArrayList<cake> cakeOrder = new ArrayList<>();
                                            cakeOrder.add(currentOrder);
                                            String orderID = mainInterface.placeOrders(
                                                    mainInterface.getCustomer(phoneNum),
                                                    LocalDateTime.now(),
                                                    null,
                                                    cakeOrder
                                            );
                                            // TODO same problem here, fixed
                                            orders CurOrder = mainInterface.getThisCustomerOrderSingle(orderID);
                                            double priceAfterTax = utils.calculateTax(0.06, CurOrder.getTotalPrice());
                                            System.out.println("Your order is successfully placed! Thank you for shopping at Secret Garden!");
                                            System.out.println("Total Price: RM" + priceAfterTax);
                                            System.out.println("Order ID:" + orderID);

                                            // TODO dont let program exit, loop it back
                                        } else {
                                            System.out.println("You have chosen an invalid response. Please try again.");
                                        }
                                    } while (addon != 1 && addon != 2);
                                }
                            } else {
                                System.out.println("You have chosen an invalid response. Please try again.");
                            }
                        } while (choice2 != 1 && choice2 != 2);

                    } else if (choice1 == 2) {

                        // currently dont have a method to test this, program just exits before it did anything

                        //TODO jun 2 sub methods
                        //1 show 1 order, order number
                        //2 show all orders, sort by 4 methods in enums
                        System.out.println("1. Would you like to see the status of one order?");
                        System.out.println("2. Would you like to see the status of all your order?");
                        int show = secretScanner.nextInt();

                        //1
                        if (show == 1) {
                            String OrderID;
                            orders single = mainInterface.getThisCustomerOrderSingle(phoneNum);
                            do {
                                System.out.println();
                                System.out.println("Please enter the order ID of the order you want to check");
                                OrderID = secretScanner.nextLine();
                                if (OrderID.equals(single.getUid())) {
                                    System.out.println(single);
                                } else {
                                    System.out.println("Your order is not found! Please try again.");
                                }
                            } while (!Objects.equals(OrderID, single.getUid()));
                        }
                        //2

                        if (show == 2) {
                            int sortChoice;
                            do {
                                System.out.println();
                                System.out.println("How do you want to sort your orders?");
                                System.out.println("1. Date");
                                System.out.println("2. Type");
                                System.out.println("3. Amount of items");
                                System.out.println("4. Order price");
                                sortChoice = secretScanner.nextInt();

                                if (sortChoice == 1) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.DATE);
                                    for (orders orderList : sorted) {
                                        System.out.println(orderList);
                                    }
                                } else if (sortChoice == 2) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.TYPE);
                                    for (orders orderList : sorted) {
                                        System.out.println(orderList);
                                    }
                                } else if (sortChoice == 3) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.AMOUNT_OF_ITEMS);
                                    for (orders orderList : sorted) {
                                        System.out.println(orderList);
                                    }
                                } else if (sortChoice == 4) {
                                    ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.ORDER_PRICE);
                                    for (orders orderList : sorted) {
                                        System.out.println(orderList);
                                    }
                                }
                            } while (sortChoice != 1 && sortChoice != 2 && sortChoice != 3 && sortChoice != 4);
                        }
                    } else if (choice1 == 3) {
                        System.out.println("Thank you for shopping at Secret Garden!");
                        //exit program
                        secretScanner.close();
                        System.exit(0);
                    } else if (choice1 == 4) {
                        System.out.println("Logging out. Thank you for shopping at Secret Garden!");
                        break;
                    } else {
                        System.out.println("You have chosen an invalid response. Please try again.");
                    }
                } while (choice1 != 1 && choice1 != 2 && choice1 != 3);
            } while (choice1 != 4);
        } while (true);
    }
}