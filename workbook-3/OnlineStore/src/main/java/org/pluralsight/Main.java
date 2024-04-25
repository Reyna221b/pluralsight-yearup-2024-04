package org.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{


    public static void main(String[] args)
    {
        int userChoice = 0;

        loadProducts();

        //displayProducts();
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


}