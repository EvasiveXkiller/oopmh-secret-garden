package mainrunnable;

import secretGarden.*;
import secretGarden.enums.sort;
import secretGarden.items.bread;
import secretGarden.items.cake;

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
            System.out.println("User found in weird thing, continuing");
        } else {
            /*if customerID is nonexistent,
            create customerID for the customer based on the phoneNum entered,
            notify customer that a new customerID i
            s created and the program proceeds
            */
            System.out.println("Not found! Creating a new one, PLease enter your name");
            String weirdName = secretScanner.nextLine();
            mainInterface.createNewCustomer(phoneNum, weirdName);
        }

        //checkCustomerID // DONE

        //if (customerID = exist) program proceeds
        System.out.println(" ");
        System.out.println("Please choose one of the following:");
        System.out.println("1. Place order");
        System.out.println("2. Get status of your order"); //TODO pavan
        System.out.println("3. Exit program");
        int choice1 = secretScanner.nextInt();

        if (choice1 == 1) {
            System.out.println("What type of order would you like to place?");
            System.out.println("1. Standard");
            System.out.println("2. Pre-Order"); // TODO ivan can take care of this
            int choice2 = secretScanner.nextInt();

            if (choice2 == 1) {
                    /*
                    getallitems -> customer will choose one and add it to cart
                    put loop and a exit method here for the customer to put more than one item to cart
                    calculate price
                    return orderID and price upon successful order
                    exit program
                    */
                ArrayList<bread> temporaryBasket = new ArrayList();
                ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                //TOOD while loop starts here
                System.out.println("These are the pavan' avaliable for now");
                for (bread item : itemsFromDB) {
                    //TODO sysout all the details of the bread
                }
                System.out.println("Enter the thing u want to add");
                int itemIndex = secretScanner.nextInt();
                System.out.println("Enter the amount that u want to for this item"); //TODO replace "this item" with more descriptive text
                int multiplier = secretScanner.nextInt();

                for (int i = 0; i < multiplier; i++) {
                    temporaryBasket.add(itemsFromDB.get(itemIndex));
                }

                // TODO until a break point
                System.out.println("Theses thing are in the cart");
                //TODO print the things out

                System.out.println("Are u sure to continue");

                if (true) {
                    String orderID = mainInterface.placeOrders(
                            mainInterface.getCustomer(phoneNum),
                            temporaryBasket
                    );
                } else {
                    // TODO break out back to the UI
                }

            }

            //CHOOSE PREORDER STARTS HERE EHRUOEHILFSDJKLFHDSILFHJLDSHJFLDSAKLJ
            else if (choice2 == 2) {
                System.out.println("You have chosen pre-order. " +
                        "Are you interested in our selection of cakes or breads? " +
                        "1 for Bread, " +
                        "2 for Cakes");
                int preorder = secretScanner.nextInt();
                if (preorder == 1) {
                    ArrayList<bread> temporaryBasket = new ArrayList();
                    ArrayList<bread> itemsFromDB = mainInterface.getAllStandardItems();
                    //TODO while loop starts here
                    System.out.println("These are the pavan' avaliable for now");
                    for (bread item : itemsFromDB) {
                        //TODO sysout all the details of the bread
                    }
                    System.out.println("Enter the thing u want to add");
                    int itemIndex = secretScanner.nextInt();
                    System.out.println("Enter the amount that u want to for this item"); //TODO replace "this item" with more descriptive text
                    int multiplier = secretScanner.nextInt();

                    for (int i = 0; i < multiplier; i++) {
                        temporaryBasket.add(itemsFromDB.get(itemIndex));
                    }

                    // TODO until a break point
                    System.out.println("Theses thing are in the cart");
                    //TODO print the things out

                    System.out.println("Are u sure to continue");
                    //TODO if the orderAmount is > 100, give them a free gift, i guess just sysout you will be given a keychain or smth
                    if (true) {
                        LocalDateTime now = LocalDateTime.now();
                        String orderID = mainInterface.placeOrders(
                                mainInterface.getCustomer(phoneNum),
                                LocalDateTime.now(),
                                temporaryBasket
                        );
                    } else {
                        // TODO break out back to the UI AND show order ID
                    }
                }
                if (preorder == 2) {
                    ArrayList<cake> cakeFromDB = mainInterface.getAllCakesItems();
                    System.out.println("These are the cakes available right now.");
                    for (cake item : cakeFromDB) {
                        //displays all the cakes to ur heart's content
                    }
                    System.out.println("Which cake are you interested in?");
                    int cakeIndex = secretScanner.nextInt();
                    cake currentOrder = new cake(
                            cakeFromDB.get(cakeIndex).getName(),
                            cakeFromDB.get(cakeIndex).getPrice()
                    );
                    // TODO redesign UI
                    System.out.println("Are you interested in our add-on services (custom design & custom candles)? [1 for YES || 2 for NO]");
                    int addon = secretScanner.nextInt();
                    if (addon == 1) {
                        // TODO UI
                        String customDesign = secretScanner.nextLine();
                        currentOrder.setCustomDesign(customDesign);

                        String customCandles = secretScanner.nextLine();
                        currentOrder.setCustomCandles(customCandles);
                    }
                    if (addon == 2) {
                        // TODO until a break point
                        System.out.println("Theses thing are in the cart");
                        //TODO print the things out

                        System.out.println("Are u sure to continue");
                        ArrayList<Object> cakeOrder = new ArrayList<>();
                        cakeOrder.add(currentOrder);
                        if (false) {
                            LocalDateTime now = LocalDateTime.now();
                            String orderID = mainInterface.placeOrders(
                                    mainInterface.getCustomer(phoneNum),
                                    LocalDateTime.now(),
                                    cakeOrder
                            );
                        } else {
                            // TODO break out back to the UI AND show order ID
                        }

                    }

                    if (addon == 3) {
                        System.out.println("'look at this dude thinking he's funny entering another number','bruh ifkr, get a life bruh its 1 or 2.'");
                    }
                } else {
                    System.out.println("'look at this dude thinking he's funny entering another number','bruh ifkr, get a life bruh its 1 or 2.'");
                }
                    /*
                    getcake and fill in secretGarden.items.cake styles and data
                    put loop and a exit method here for the customer to put more than one item to cart
                    calculate price
                    return orderID and price upon successful order
                    exit program
                    */
                //TODO ivan code insert here
            } else {
                System.out.println("Do you not know how numbers work?");
                //figure out loop on wrong input at a later time
            }
        } else if (choice1 == 2) {


            //TODO jun 2 sub methods
            //1 show 1 order, order number
            //2 show all orders, sort by 4 methods in enums

            /*
            if there are orders under customer -> getOrderStatus() under the customerID
            if there are no orders under customer -> "there are currently no active orders"
            loops back to choice 1
            */

            //1
            orders single = mainInterface.getThisCustomerOrderSingle("");

            //2
            System.out.println("customer ID + Customer name");
            ArrayList<orders> sorted = mainInterface.getThisCustomerOrder(phoneNum, sort.DATE);
            //TODO print it out here;
            // wait for ui
        } else if (choice1 == 3) {
            System.out.println("Thank you for shopping at Secret Garden!");
            //exit program
            secretScanner.close();
            System.exit(0);
        } else {
            System.out.println("Do you not know how numbers work?");
            //figure out loop on wrong input at a later time
        }
        secretScanner.close();
    }
}