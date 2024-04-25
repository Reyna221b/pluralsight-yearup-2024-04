package org.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import org.pluralsight.Product;

public class UserInterface
{
    private static ArrayList<Product> products = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void userChoice(){

        while(true)
        {
            int choice = getHomeScreenChoice();

            switch(choice)
            {
                case 1: // available books
                    showAvailableBooks();
                    break;
                case 2: // checked out books
                    showCheckedOutBooks();
                    break;
                case 3: // exit
                    ui.displayMessage("Thank You! Come again.");
                    return;
                default: // invalid selection
                    ui.displayMessage("That was an invalid selection.");
                    break;
            }

        }
    }

    public int getHomeScreenChoice()
    {
        System.out.println();
        System.out.println("Home Screen!");
        System.out.println("-".repeat(30));
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine().strip());
    }

    public static void displayProducts()
    {
        System.out.println("SKU #\t\t\tProduct Name" + " ".repeat(30 ) + "Price");
        System.out.println("-".repeat(70));

        for (Product product : products) {
            System.out.printf("%5s\t\t\t%-40s $ %.2f", product.getSku(),product.getName(), product.getPrice());
            System.out.println();
        }
    }
}
