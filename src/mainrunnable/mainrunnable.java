package mainrunnable;


import secretGarden.*;

import java.util.Scanner;

// TODO Flow as belows
/*

program start -> 2 choices -> placeorder
                           -> getOrderStatus

placeorder -> [checkCustomerID] -> 2 choices -> standard -> getAllItems to select -> additems to cart
                                             -> preorder -> getcake and fill in secretGarden.items.cake styles and data
                                             @returns -> string : orderID

preorder for cake and bread are seperated and should be done in 2 transcations.[avoid making the class too complicated]

if customer ID non existent then create one and return the ID, else pass in the customer ID [the ID use phone number for now, easier to manage]

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
        Scanner kekw = new Scanner(System.in);
        System.out.println("Do you have a secretGarden.customer ID?");
    }
}
