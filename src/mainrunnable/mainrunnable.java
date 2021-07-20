package mainrunnable;

import secretGarden.*;
import secretGarden.database.pseudoDatabase;
import secretGarden.enums.order;
import secretGarden.enums.sort;
import secretGarden.items.bread;
import secretGarden.items.cake;
import secretGarden.utils.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


// TODO Flow as belows
/*
program start -> 2 choices -> placeorder
                           -> getOrderStatus
program start -> asks for cutomer's phone number(id)
if custID exist -> proceed with program
else            -> create custID for customer
2 choices -> placeorder
          -> getOrderStatus
placeorder -> [checkCustomerID] -> 2 choices -> standard -> getAllStandardItems to select -> additems to cart
                                             -> preorder -> getcake and fill in secretGarden.items.cake styles and data
                                             @returns -> string : orderID
preorder for cake and bread are seperated and should be done in 2 transcations.[avoid making the class too complicated]
if customer ID non existent then create one and return the ID, else pass in the customer ID [the ID use phone number for now, easier to manage]
getOrderStatus -> get all the order status under the customer id that is inputted.
if no order found -> tell the customer that there is no order found.
getOrder -> go to the database and find the order id
getCustomerInfo -> go to database to find customer info.
*/

public class mainrunnable {

    public static void main(String[] args) {
        secretGarden mainInterface = new secretGarden();
        Scanner secretScanner = new Scanner(System.in);
        System.out.println("Welcome to Secret Garden automated ordering system.");
        System.out.println("Please enter your phone number.");
        String phoneNum = secretScanner.nextLine();

        if (mainInterface.checkIfCustomerExists(phoneNum)) {
            System.out.println("User found in database, continuing.");
        } else {
            /*if customerID is nonexistent,
            create customerID for the customer based on the phoneNum entered,
            notify customer that a new customerID i
            s created and the program proceeds
            */
            System.out.println("Your phone number is not found! Please enter your name to create an account.");
            String customerName = secretScanner.nextLine();
            mainInterface.createNewCustomer(phoneNum, customerName);
        }
        System.out.println(" ");
        System.out.println("Please choose one of the following:");
        System.out.println("1. Place order");
        System.out.println("2. Get status of your order"); //TODO pavan
        System.out.println("3. Exit program");
        int choice1;
        
        do {
        choice1 = secretScanner.nextInt();
        if (choice1 == 1) {
            System.out.println("What type of order would you like to place?");
            System.out.println("1. Standard");
            System.out.println("2. Pre-Order"); // TODO ivan can take care of this
            int choice2;

            do {
            choice2 = secretScanner.nextInt();
            if (choice2 == 1) {
                    /*
                    getallitems -> customer will choose one and add it to cart
                    put loop and a exit method here for the customer to put more than one item to cart
                    calculate price
                    return orderID and price upon successful order
                    exit program
                    */
                ArrayList<bread> temporaryBasket = new ArrayList<>();
                ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                //TOOD while loop starts here
                System.out.println("These are the breads avaliable in our bakery.");
                for (bread item : itemsFromDB) {
                    //need an index here
                    System.out.println("Bread:" + item.getName());
                    System.out.println("Price:" + item.getPrice());
                }

                int checkOut;
                do {
                System.out.println("You can add these items to the cart.");
                int itemIndex = secretScanner.nextInt();
                System.out.println("Enter the amount that u want to for this item."); //TODO replace "this item" with more descriptive text
                int multiplier = secretScanner.nextInt();
                
                for (int i = 0; i < multiplier; i++) {
                    temporaryBasket.add(itemsFromDB.get(itemIndex));
                }

                
                // TODO until a break point
                System.out.println("Theses thing are in the cart.");
                //TODO print the things out
                for (int i = 0; i < temporaryBasket.size(); i++){
                    System.out.println(temporaryBasket.get(i));
                    //not sure how to access the price
                }

                System.out.println("Continue to checkout?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                checkOut = secretScanner.nextInt();

                if (checkOut == 1) {
                    String orderID = mainInterface.placeOrders(
                            mainInterface.getCustomer(phoneNum),
                            temporaryBasket
                    );
                    orders CurOrder = mainInterface.getThisCustomerOrderSingle(phoneNum);
                    double priceAfterTax = utils.calculateTax(0.06, CurOrder.getPrice());
                    System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                    System.out.println("Total Price: RM" + priceAfterTax);
                    System.out.println("Order ID:" + orderID);
                }
                else {
                    System.out.println("Returning");
                }
            } while (checkOut != 1);
            }

            //CHOOSE PREORDER STARTS HERE EHRUOEHILFSDJKLFHDSILFHJLDSHJFLDSAKLJ
            else if (choice2 == 2) {
                System.out.println("You have chosen pre-order. " +
                        "Are you interested in our selection of cakes or breads? " +
                        "1 for Bread, " +
                        "2 for Cakes");
                int preorder = secretScanner.nextInt();
                if (preorder == 1) {
                    ArrayList<bread> temporaryBasket = new ArrayList<>();
                    ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                    int checkOut2;
                    //TODO while loop starts here
                    do {
                    System.out.println("These are the breads in our bakery.");
                    for (bread item : itemsFromDB) {
                        System.out.println("Bread:" + item.getName());
                        System.out.println("Price:" + item.getPrice());
                    }
                    System.out.println("You can add these items to the cart.");
                    int itemIndex = secretScanner.nextInt();
                    System.out.println("Enter the amount that u want to for this item."); //TODO replace "this item" with more descriptive text
                    int multiplier = secretScanner.nextInt();

                    for (int i = 0; i < multiplier; i++) {
                        temporaryBasket.add(itemsFromDB.get(itemIndex));
                    }       
                System.out.println("Theses thing are in the cart");

                    for (int i = 0; i < multiplier; i++) {
                        temporaryBasket.add(itemsFromDB.get(itemIndex));
                    }
                    
                System.out.println("Continue to checkout?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                checkOut2 = secretScanner.nextInt();

                
                    if (checkOut2 == 1) {
                        LocalDateTime now = LocalDateTime.now();
                        String orderID = mainInterface.placeOrders(
                                mainInterface.getCustomer(phoneNum),
                                LocalDateTime.now(),
                                temporaryBasket,
                                null
                        );
                        orders CurOrder = mainInterface.getThisCustomerOrderSingle(phoneNum);
                        if (CurOrder.getPrice() > 100) {
                                System.out.println("You are entitled to receive a free gift!");
                        }
                        
                        double priceAfterTax = utils.calculateTax(0.06, CurOrder.getPrice());
                        System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                        // TODO add calculate price here
                        System.out.println("Total Price: RM" + priceAfterTax);
                        System.out.println("Order ID:" + orderID);
                    }
                    else {
                        System.out.println("Returning...");
                    }
                } while (checkOut2 != 1);
                }

                if (preorder == 2) {
                    ArrayList<cake> cakeFromDB = mainInterface.getAllCakesItems();
                    System.out.println("These are the cakes available right now.");
                    for (cake item : cakeFromDB) {
                        //need an index here
                        System.out.println("Cake:" + item.getName());
                        System.out.println("Price:" + item.getPrice());
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
                        String customDesign = secretScanner.nextLine();
                        currentOrder.setCustomDesign(customDesign);

                        System.out.println("Please describe the candle of the cake. (Number of candles, shape, colour, etc.)");
                        String customCandles = secretScanner.nextLine();
                        currentOrder.setCustomCandles(customCandles);
                    }
                    
                    if (addon == 2) {
                        //TODO print the things out
                        System.out.println("Continuing to checkout.");
                        ArrayList<cake> cakeOrder = new ArrayList<>();
                        cakeOrder.add(currentOrder);
                            LocalDateTime now = LocalDateTime.now();
                            String orderID = mainInterface.placeOrders(
                                    mainInterface.getCustomer(phoneNum),
                                    LocalDateTime.now(),
                                    null,
                                    cakeOrder
                            );
                        orders CurOrder = mainInterface.getThisCustomerOrderSingle(phoneNum);
                        double priceAfterTax = utils.calculateTax(0.06, CurOrder.getPrice());
                        System.out.println("Your order is succesfully placed! Thank you for shopping at Secret Garden!");
                        System.out.println("Total Price: RM" + priceAfterTax);
                        System.out.println("Order ID:" + orderID);
                    }
                    else {
                        System.out.println("You have chosen an invalid response. Please try again.");
                    }
                } while (addon != 1 && addon != 2);
                }
            } else {
                System.out.println("You have chosen an invalid response. Please try again.");
            }
        }while (choice2 != 1 && choice2 != 2);
        
        } else if (choice1 == 2) {

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
                do{
                    System.out.println();
                    System.out.println("Please enter the order ID of the order you want to check");
                    OrderID = secretScanner.nextLine();
                        if (OrderID == single.getUid()){
                            System.out.println(single);
                    }
                        else {
                            System.out.println("Your order is not found! Please try again.");
                    }
                }while (OrderID != single.getUid());
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
            }
            else if (sortChoice == 2) {
                ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.TYPE);
                for (orders orderList : sorted) {
                    System.out.println(orderList);
                }
            }
            else if (sortChoice == 3) {
                ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.AMOUNT_OF_ITEMS);
                for (orders orderList : sorted) {
                    System.out.println(orderList);
                }
            }
            else if (sortChoice == 4) {
                ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.ORDER_PRICE);
                for (orders orderList : sorted) {
                    System.out.println(orderList);
                }
            }
            }while (sortChoice != 1 && sortChoice != 2 && sortChoice !=3 && sortChoice != 4);
        }
        } else if (choice1 == 3) {
            System.out.println("Thank you for shopping at Secret Garden!");
            //exit program
            secretScanner.close();
            System.exit(0);
        } else {
            System.out.println("You have chosen an invalid response. Please try again.");
        }
    }while (choice1 != 1 && choice1 != 2 && choice1!= 3);
        secretScanner.close();
    }
}