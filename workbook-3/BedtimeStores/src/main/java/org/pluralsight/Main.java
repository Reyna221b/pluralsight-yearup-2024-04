package org.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = userInput.nextLine();

        String filePath = ("files/" + fileName);
        File file = new File(filePath);

        try(Scanner fileScanner = new Scanner(file))
        {

            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            System.out.println();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("That was a bad file name");
        }
    }

}