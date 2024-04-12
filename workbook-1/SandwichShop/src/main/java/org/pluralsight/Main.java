package org.pluralsight;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner userInput = new Scanner(System.in);

        int productID;
        int customerAge;
        double sandwich1Price = 5.45;
        double sandwich2Price = 8.95;
        double discount;


        System.out.printf("Sandwich Menu: \n1: Regular - $ %.2f \n2: Large - $ %.2f ",
                sandwich1Price, sandwich2Price);
        System.out.print("\nPlease choose the size of your sandwich (1 or 2): ");
        productID = userInput.nextInt();

        System.out.println();

        System.out.print("Depending on your age you may qualify for a discount! \nPlease enter your age:");
        customerAge = userInput.nextInt();


        if(customerAge <= 17){

            if (productID == 1 ){
                discount = sandwich1Price * .10;
                sandwich1Price = sandwich1Price - discount;
                System.out.printf("\nYour total is $ %.2f for product # %d! ", sandwich1Price, productID );
            }
            else {
                discount = sandwich2Price * .10;
                sandwich2Price = sandwich2Price - discount;
                System.out.printf("\nYour total is $ %.2f for product # %d! ", sandwich2Price, productID );
            }

        }

        if(customerAge >= 65){

            if (productID == 1 ){
                discount = sandwich1Price * .20;
                sandwich1Price = sandwich1Price - discount;
                System.out.printf("\nYour total is $ %.2f for product # %d! ", sandwich1Price, productID );
            }
            else {
                discount = sandwich2Price * .20;
                sandwich2Price = sandwich2Price - discount;
                System.out.printf("\nYour total is $ %.2f for product # %d! ", sandwich2Price, productID );
            }

        }


    }


}