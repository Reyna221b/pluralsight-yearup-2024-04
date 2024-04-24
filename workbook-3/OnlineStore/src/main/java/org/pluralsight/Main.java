package org.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args)
    {
        int userChoice = 0;

        System.out.println("Welcome to the neighborhood Library!");
        while (userChoice != 3) {
            userChoice = getHomeScreenChoice();

            switch (userChoice)
            {
                case 1:
                    availableBooks(books);
                    break;
                case 2:
                    checkedOutBooks(books);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Thank you for visiting the NeighborHood Library!\nGoodbye!");
                    return;
                default:
                    System.out.println();
                    System.out.println("Sorry that is not an option.");
                    break;
            }

        }
        loadProducts();

        displayProducts();
    }

    public static void getHomeScreenChoice()
    {
        System.out.println();
        System.out.println("Home Screen!");
        System.out.println("---------------------------------");
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        return Integer.parseInt(userInput.nextLine());
    }

    public static void loadProducts(){

        File file = new File("files/products.csv");
        try(Scanner fileScanner = new Scanner(file))
        {
            fileScanner.nextLine();

            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();

                String[] columns = line.split("[|]");

                String sku = columns[0];
                String name = columns[1];
                double price = Double.parseDouble(columns[2]);
                String department = columns[3];
                Product product = new Product(sku, name, price, department);
                products.add(product);
            }
        }
        catch(IOException ex)
        {

        }
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

    public static String searchProduct(){

    }

}