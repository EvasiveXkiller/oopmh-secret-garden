package mainrunnable;


import secretGarden.*;
import secretGarden.enums.membership;

import java.util.Scanner;


// TODO Flow as belows
/*

program start -> asks for cutomer's phone number(id)

if custID exist -> proceed with program
else            -> create custID for customer

2 choices -> placeorder
          -> getOrderStatus

placeorder -> [checkCustomerID] -> 2 choices -> standard -> getAllItems to select -> additems to cart
                                             -> preorder -> getcake and fill in secretGarden.items.cake styles and data
                                             @returns -> string : orderID

preorder for cake and bread are seperated and should be done in 2 transcations.[avoid making the class too complicated]

getOrderStatus -> get all the order status under the customer id that is inputted.
if no order found -> tell the customer that there is no order found.

getOrder -> go to the database and find the order id
getCustomerInfo -> go to database to find customer info.


customerClass
getMembershipStatus -> if it is premium then 5 percent discount [can be used for checking and internal processing]
updateMembershipStatus -> autoCalculate next expiration date

orderClass
calculatePrice -> calculate the order price
calculatePriceFeatures -> check is there any discounts should be added



footnotes : reply things might be another class

such as orderReply should be another class
*/


public class mainrunnable {

    public static void main(String[] args) {
        secretGarden mainInterface = new secretGarden();
        Scanner secretScanner = new Scanner(System.in);
        System.out.println("Welcome to Secret Garden automated ordering system.");
        // typing a certain phone number will cause to program to exit, will use that as an exit system
        System.out.println("Please enter your phone number.");
        String phoneNum = secretScanner.nextLine();
        //checkCustomerID
        //if customerID is nonexistent, create customerID for the customer based on the phoneNum entered, notify customer that a new customerID is created and the program proceeds
        //if (customerID = exist) program proceeds
        System.out.println(" ");
        System.out.println("Please choose one of the following:");
        System.out.println("1. Place order");
        System.out.println("2. Get status of your order");
        // added this new line
        System.out.println("3. Logout");
        int choice1 = secretScanner.nextInt();

        if (choice1 == 1) {
            System.out.println("What type of order would you like to place?");
            System.out.println("1. Standard");
            System.out.println("2. Pre-Order");
            int choice2 = secretScanner.nextInt();

            if (choice2 == 1) {
                    /*
                    getallitems -> customer will choose one and add it to cart
                    put loop and a exit method here for the customer to put more than one item to cart
                    calculate price
                    return orderID and price upon successful order
                    exit program
                    */
            } else if (choice2 == 2) {
                    /*
                    getcake and fill in secretGarden.items.cake styles and data
                    put loop and a exit method here for the customer to put more than one item to cart
                    calculate price
                    return orderID and price upon successful order
                    exit program
                    */
            } else {
                System.out.println("Do you not know how numbers work?");
                //figure out loop on wrong input at a later time
            }
        } else if (choice1 == 2) {

            /*
            if there are orders under customer -> getOrderStatus() under the customerID
            if there are no orders under customer -> "there are currently no active orders"
            loops back to choice 1
            */

        } else if (choice1 == 3) {
            System.out.println("Thank you for shopping at Secret Garden!");
            //exit program
        } else {
            System.out.println("Do you not know how numbers work?");
            //figure out loop on wrong input at a later time
        }
        secretScanner.close();
        System.exit(0);
    }
}
