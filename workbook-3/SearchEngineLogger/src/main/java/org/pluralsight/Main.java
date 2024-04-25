package org.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        logMessage("Start application");

        while(true)
        {
            System.out.println();
            System.out.print("Search for a term or x to Exit: ");
            String search = userInput.nextLine();

            try
            {
                if (search.equalsIgnoreCase("x") )
                {
                    logMessage("End application");
                    break;
                }
                logMessage(search);
            }
            catch(Exception ex)
            {
                System.out.println("There was a problem, please try again.");
                logMessage("Error: " + ex.getMessage());
            }

        }
    }

    public static void logMessage(String message)
    {
        File file = new File("logs/application.log");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("kk:mm:ss");

        try(
                FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            writer.printf("%s %s - %s\n", now.format(dateFormatter), now.format(timeFormatter), message);
        }
        catch (Exception ex)
        {

        }
    }
}